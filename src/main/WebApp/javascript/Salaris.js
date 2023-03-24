const apiBaseUrl = "http://localhost:8083/HRM_final_war/api"

// Get all werkuren
async function getAllWerkuren() {
    const response = await fetch(`${apiBaseUrl}/werkuren/list`);
    const werkuren = await response.json();
    return werkuren;
}

// Get werkuur by ID
async function getWerkuurById(id) {
    const response = await fetch(`${apiBaseUrl}/werkuren/${id}`);
    const werkuur = await response.json();
    return werkuur;
}


// Add a new werkuur
async function addWerkuur(werkuur) {
    const response = await fetch(`${apiBaseUrl}/werkuren/add`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(werkuur),
    });
    const newWerkuur = await response.json();
    return newWerkuur;
}

// Update an existing werkuur
async function updateWerkuur(werkuur) {
    const response = await fetch(`${apiBaseUrl}/werkuren/update`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(werkuur),
    });
    if (response.status === 404) {
        throw new Error("User not found");
    }
    const updatedWerkuur = await response.json();
    return updatedWerkuur;
}

// Delete a Werkuur by ID
async function deleteWerkuur(id) {
    const response = await fetch(`${apiBaseUrl}/werkuren/delete/${id}`, {
        method: "DELETE",
    });
    if (response.status === 404) {
        throw new Error("User not found");
    }
}