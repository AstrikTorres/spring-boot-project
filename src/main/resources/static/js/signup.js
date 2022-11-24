// username must be at least 3 characters long and can contain only letters, numbers and underscores. The first character must be a letter.
const validUsername = /^[A-Za-z][A-Za-z0-9_.]{2,11}$/
// password must be at least 4 characters long and can contain letters, numbers and some symbols like !@#$%^&*()_+=-
const validPassword = /[A-Za-z0-9_!@#$%^&*()_+=-]{4,20}$/

const form = document.getElementById('signup-form')
const formData = new FormData(form);

form.addEventListener('submit', (event) => {
  event.preventDefault()
  console.log('submitting form')
});