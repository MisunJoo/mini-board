document.getElementById('country').addEventListener('change', () => {
    let selectedValue = document.getElementById('country').value;
    location.href = `/miniboard/${selectedValue}`;
});