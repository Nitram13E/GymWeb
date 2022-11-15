//---------------Nav Bar------------------
const $profileUserIcon = document.querySelector(".nav-item #profile-user-icon");
const $dropDownProfile = document.getElementById("dropdown-profile");

$profileUserIcon.addEventListener("click", function()
{
    $dropDownProfile.classList.toggle("show");
});

function triggerRegistroClase(elemento)
{
    window.location = elemento.value;
}

