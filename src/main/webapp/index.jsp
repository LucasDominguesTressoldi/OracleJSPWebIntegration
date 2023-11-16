<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="icon" href="assets/wisepaylogo.ico" type="image/ico">
  <title>WisePay</title>
  <link rel="stylesheet" href="css/reset.css">
  <link rel="stylesheet" href="css/body.css">
  <link rel="stylesheet" href="css/header.css">
  <link rel="stylesheet" href="css/cadastro/main-content.css">
</head>

<body>
  <section class="header">
    <div class="left">
      <img class="logo" src="assets/logo.svg" alt="Uma mão, em desenho, segurando notas de dinheiro">
      <a href="#">
        Minha Conta
      </a>
      <a href="#">
        Meu Histórico
      </a>
      <a href="#">
        Investimentos
      </a>
      <a href="#">
        Suporte
      </a>
    </div>
    <div class="right">
      <img class="btn-icons avatar" src="assets/avatar.svg"
        alt="Uma pessoa representada do pescoço para cima, e em forma de desenho, dentro de um círculo">
      <img class="btn-icons" src="assets/notification.svg" alt="Um sino">
      <img class="btn-icons" src="assets/setting.svg" alt="Uma engrenagem">
    </div>
  </section>

  <hr class="white-div">

  <section class="main-content">
    <p>Crie uma conta WisePay! É rápido e simples.</p>
    <div class="inputs">
      <div class="name wrapped">
        <label for="fullname">Nome Completo</label>
        <input type="text" id="fullname" placeholder="Matheus Silva" required>
      </div>
      <div class="cpf wrapped">
        <label for="cpf">CPF</label>
        <input type="text" id="cpf" placeholder="658.741.903-07" required>
      </div>
      <div class="pswd wrapped">
        <label for="pswd">Senha</label>
        <input type="text" id="pswd" placeholder="********" required>
      </div>
      <div class="birth wrapped">
        <label for="birth">Data de Nascimento</label>
        <input type="text" id="birth" placeholder="09/12/1991" required>
      </div>
      <div class="cel wrapped">
        <label for="cel">Telefone</label>
        <input type="text" id="cel" placeholder="(12)99654-3321" required>
      </div>
      <div class="email wrapped">
        <label for="email">Email</label>
        <input type="text" id="email" placeholder="meu.email@email.com" required>
      </div>
    </div>
    <button class="sign-up" type="submit">Cadastrar</button>
    <p>Já tem uma conta? <a href="login.jsp"><span class="enter">Entrar</span></a></p>
  </section>
</body>

</html>