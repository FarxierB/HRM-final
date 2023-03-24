const API_URL = "http://localhost:8083/HRM_final_war/api/werknemer"



// Get all werknemers
function getWerknemers() {
    return fetch(`${API_URL}/list`)
        .then(response => response.json())
        .catch(error => console.error('Error:', error));
}

// Get werknemer by ID
function getWerknemer(id) {
    return fetch(`${API_URL}/${id}`)
        .then(response => response.json())
        .catch(error => console.error('Error:', error));
}

// Create a new Werknemer
function createWerknemer(werknemer) {
    return fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(werknemer)
    })
        .then(response => response.json())
        .catch(error => console.error('Error:', error));
}

// Update a werknemer
function updateWerknemer(id, werknemer) {
    return fetch(`${API_URL}/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(werknemer)
    })
        .then(response => {
            if (response.status === 200) {
                return response.json();
            } else {
                throw new Error("Error updating werknemer");
            }
        })
        .catch(error => console.error('Error:', error));
}

// Delete a werknemer by ID
function deleteWerknemer(id) {
    return fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    })
        .then(response => {
            if (response.status === 200) {
                return response.json();
            } else {
                throw new Error("Error deleting task");
            }
        })
        .catch(error => console.error('Error:', error));
}

// Assign a functie to a Werknemer
function assignFunctieToWerknemer(werknemerId, functie) {
    return fetch(`${API_URL}/${werknemerId}/functie`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(functie)
    })
        .then(response => {
            if (response.status === 200) {
                return response.json();
            } else {
                throw new Error("Error assigning user to task");
            }
        })
        .catch(error => console.error('Error:', error));
}

// Unassign a functie from a Werknemer
function unassignFunctieFromWerknemer(werknemerId, functieId) {
    return fetch(`${API_URL}/${werknemerId}/functie/${functieId}`, {
        method: "DELETE"
    })
        .then(response => {
            if (response.status === 200) {
                return response.json();
            } else {
                throw new Error("Error unassigning user from task");
            }
        })
        .catch(error => console.error('Error:', error));
}
