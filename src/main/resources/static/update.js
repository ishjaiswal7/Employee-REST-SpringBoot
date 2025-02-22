document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("updateForm").addEventListener("submit", async function(event) {
        event.preventDefault(); // Prevent page reload

        const employeeId = document.getElementById("employeeId").value;
        const name = document.getElementById("name").value;
        const email = document.getElementById("email").value;

        const updatedEmployee = {
            name: name,
            email: email
        };

        try {
            const response = await fetch(`http://localhost:8082/api/employees/${employeeId}`, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(updatedEmployee)
            });

            const messageElement = document.getElementById("message");

            if (response.ok) {
                messageElement.textContent = "Employee updated successfully!";
                messageElement.style.color = "green";
            } else {
                const errorText = await response.text();
                messageElement.textContent = "Error updating employee: " + errorText;
                messageElement.style.color = "red";
            }
        } catch (error) {
            document.getElementById("message").textContent = "Network error: " + error.message;
            document.getElementById("message").style.color = "red";
        }
    });
});
