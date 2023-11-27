function submitForm() {
    var registered = document.getElementById("registered").value;
    var emailAddress = document.getElementById("email_address").value;
    var title = document.getElementById("title").value;
    var first_Name = document.getElementById("first_Name").value;
    var last_Name = document.getElementById("last_Name").value;
    var address_line_1 = document.getElementById("address_line_1").value;
    var address_line_2 = document.getElementById("address_line_2").value;
    var city = document.getElementById("city").value;
    var postcode = document.getElementById("postcode").value;
    var phoneNumber = document.getElementById("phone_number").value;

    // Send data to the backend
    fetch('/registration', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            registered: registered,
            emailAddress: emailAddress,
            title: title,
            first_Name: first_Name,
            last_Name: last_Name,
            address_line_1: address_line_1,
            address_line_2: address_line_2,
            city: city,
            postcode: postcode,
            phoneNumber: phoneNumber
        }),
    })
    .then(response => response.json())
    .then(data => {
        // Handle the response from the backend
        console.log(data);
    })
    .catch(error => {
        console.error('Error:', error);
    });
}
