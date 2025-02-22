document.getElementById("employeeForm").addEventListener("submit", async function(event) {
    event.preventDefault(); // Prevent default form submission

    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const messageElement = document.getElementById("message");

    const employee = { name, email };

    try {
        const response = await fetch("http://localhost:8082/api/employees", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(employee)
        });

        if (!response.ok) {
            throw new Error(`Error: ${response.status} - ${response.statusText}`);
        }

        const result = await response.json();
        messageElement.innerHTML = `<span style="color: green;">Employee added successfully! ID: ${result.id}</span>`;
        document.getElementById("employeeForm").reset();
    } catch (error) {
        messageElement.innerHTML = `<span style="color: red;">${error.message}</span>`;
    }
});