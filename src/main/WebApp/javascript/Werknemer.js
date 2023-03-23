function search() {
    // Get the search query from the input field
    const query = document.getElementById('search-input').value;

    // Make an AJAX call to the API endpoint
    fetch(`http://localhost:8081/hrm_war/api/werknemer/${query}`)
        .then(response => response.json())
        .then(data => {
            // Do something with the data, such as displaying it on the page
            console.log(data);
        })
        .catch(error => {
            // Handle errors here
            console.error(error);
        });
}