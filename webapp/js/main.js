
/*
document.getElementById("country").addEventListener("change", function() {
    var selectedCountry = document.getElementById("country").value;
    location.href = '/miniboard?country=${selectedCountry}';
});
*/


document.getElementById('country').addEventListener('change', () => {
    let selectedValue = document.getElementById('country').value;
    location.href = `/miniboard${selectedValue}`;
});