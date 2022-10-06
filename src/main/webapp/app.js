var $profileUserIcon = document.getElementById("profile-user-icon");
var $dropDownProfile = document.getElementById("dropdown-profile");

$profileUserIcon.addEventListener("click", function()
{
    $dropDownProfile.classList.toggle("show");
});
