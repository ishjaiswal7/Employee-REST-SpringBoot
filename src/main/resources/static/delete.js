document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("deleteForm").addEventListener("submit", async function(event) {
        event.preventDefault(); // Prevent default form submission

        const employeeId = document.getElementById("employeeId").value.trim();
        const messageElement = document.getElementById("message");

        if (!employeeId) {
            messageElement.innerHTML = <span style="color: red;">Please enter a Employee ID!</span>;
            return false;
        }

        try {
            const response = await fetch(`http://localhost:8082/api/employees/${employeeId}`, {
                method: "DELETE"
            });

            if (response.status === 204) {
                messageElement.innerHTML = `<span style="color: green;">User deleted successfully!</span>`;
                document.getElementById("deleteForm").reset();
            } else if (response.status === 404) {
                messageElement.innerHTML = `<span style="color: red;">User not found!</span>`;
            } else {
                throw new Error(`Error: ${response.status} - ${response.statusText}`);
            }
        } catch (error) {
            messageElement.innerHTML = `<span style="color: red;">${error.message}</span>`;
        }

        return false; // Ensure form doesn't reload
    });
});