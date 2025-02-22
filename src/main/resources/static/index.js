const API_URL = "http://localhost:8082/api/employees"; // Update with your actual API URL

// Function to fetch all employees
async function fetchAllEmployees() {
    try {
        const response = await fetch(API_URL);
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        const employees = await response.json();
        displayEmployees(employees);
    } catch (error) {
        console.error("Error fetching employees:", error);
    }
}

// Function to display employees in the table
function displayEmployees(employees) {
    const tableBody = document.getElementById("employeeTableBody");
    tableBody.innerHTML = ""; // Clear previous entries

    employees.forEach(employee => {
        const row = document.createElement("tr");

        row.innerHTML = `
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.email}</td>
        `;

        tableBody.appendChild(row);
    });
}

// Call fetchAllEmployees when page loads
document.addEventListener("DOMContentLoaded", fetchAllEmployees);