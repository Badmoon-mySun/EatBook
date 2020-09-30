function validateForm() {
             var password = document.getElementById("password").value;
             var password2 = document.getElementById("password2").value;
             var number = document.getElementById("number").value;
             var name = document.getElementById("name").value;
             var reg = "/[0-9]{5,}/";
             if (password != password2) {
                 alert("Пароли не совпадают. Пожалуйста, введите корректные данные.");
                 return false;
             }
             if (password.length < 7) {
                alert("Пароль не должен содержать меньше, чем 7 символов");
                return false;
             }
             if (name.length > 16) {
                alert("Имя не должно содержать больше 16 букв");
                return false;
             }
 
             return true;
         }
         function validateForm2() {
             var number = document.getElementById("number").value;
             var name = document.getElementById("name").value;
             var age = document.getElementById("age").value;
             if (name.length > 16) {
                alert("Имя не должно содержать больше 16 букв");
                return false;
             }
             if (age.length > 3 || age.length == 0) {
                alert("Возраст должен содержать минимум одну цифру, но не больше 3 цифр");
                return false;
             }
             if (number.length == 0) {
                alert("Телефон не должен быть пустым полем")
             }

             return true;
         }
    function proverkaNumber(input) {
    var value = input.value; 
    var rep = /[-\.;()/":'a-zA-Zа-яА-Я]/;
    var numb = /[0-9]/;
    if (value.length > 12) {
      value = value.replace(numb, '');
      input.value = value;
    }
    if (rep.test(value)) { 
        value = value.replace(rep, ''); 
        input.value = value; 
      }
    }
    function proverkaAge(input) {
    var value = input.value; 
    var rep = /[-\.;()/":'a-zA-Zа-яА-Я]/;
    if (rep.test(value)) { 
        value = value.replace(rep, ''); 
        input.value = value; 
      }
    }
    function proverkaName(input) {
      var value = input.value;
      if (value.length > 16) {
        value = value.replace(/[]/, "");
        input.value = value;
      }
    }