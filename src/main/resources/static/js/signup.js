// username must be at least 3 characters long and can contain only letters, numbers and underscores. The first character must be a letter.
const validUsername = /^[A-Za-z][A-Za-z0-9_.]{2,11}$/
// password must be at least 4 characters long and can contain letters, numbers and some symbols like !@#$%^&*()_+=-
const validPassword = /[A-Za-z0-9_!@#$%^&*()_+=-]{4,20}$/

const form = document.getElementById('signup-form')

form.addEventListener('submit', (event) => {
  const formData = new FormData(form);
  event.preventDefault()
  if (formData.get('username') === '' || formData.get('password') === '') {
    alert('Username and password are required')
  }
  else if (!validUsername.test(formData.get('username'))) {
    alert('Username must be at least 3 characters long and can contain only letters, numbers and underscores. The first character must be a letter.')
  }  else if (formData.get('password') !== formData.get('confirmPassword')) {
    alert('Passwords do not match')
  }
  else if (!validPassword.test(formData.get('password'))) {
    alert('Password must be at least 4 characters long and can contain letters, numbers and some symbols like !@#$%^&*()_+=-')
  }
  else if (formData.get('password') !== formData.get('confirmPassword')) {
    alert('Passwords do not match')
  }

  if (validUsername.test(formData.get('username')) && validPassword.test(formData.get('password')) && formData.get('password') === formData.get('confirmPassword')) {
    console.log('Form is valid')
    axios.post('/api/users/register', {
      username: formData.get('username'),
      password: formData.get('password')
    })
      .then(function (response) {
        if (response.status === 201) {
          window.location.href = '/login'
        }
      })
      .catch(function (error) {
        if (error.response.status === 409) {
          alert('Username is already taken')
        }
      });
  }
});