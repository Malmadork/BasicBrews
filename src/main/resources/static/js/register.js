document.querySelector("form").addEventListener("submit", function (event) {
    event.preventDefault();

    let email = document.getElementById("email-register").value;
    let password = document.getElementById("password-register").value;
    let verify = document.getElementById("password-verify-register").value;

    let json = {"email": "" + email, "password": "" + password};

    console.log(json);

    $.ajax({
        url: '/register',
        type: 'POST',
        data: JSON.stringify(json),
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
        },
        success: function (result) {
            if(result.status === 200) {
                location.href = "/login";
            }
        },
        // error: function (xhr, status, error, data) {
        //     console.log(xhr, status, error);
        // }
        error: function (data, textStatus, xhr) {
            console.log(data);
        }
    })
})