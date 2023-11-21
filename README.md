# OracleJSPWebIntegration 🌐🍵

*This project was proposed by my college and its main objective is to create a complete website with JSP for the frontend and Java for the backend, integrating with the Oracle database.*

## ⚙️ How it works?

This project was developed to simulate a digital bank. With it, you can make transactions with your balance or credit card, pay your card bill, and even deposit money into your account.

🎯 The main part of the project is the **integration of the frontend with the backend** through various servlets. Calls to the Oracle database, where user data is stored, are made using **DAO (Data Access Object)** classes. All this is to make the user experience of registering, logging in, paying, or depositing money seem more realistic.

### Creation of SQL tables (DDL)

Below are the commands used to create tables in the Oracle database:

```
CREATE TABLE USUARIO (
    nr_cpf VARCHAR(11) PRIMARY KEY,
    nm_usuario VARCHAR(255) NOT NULL,
    ds_senha VARCHAR(255) NOT NULL,
    dt_nascimento DATE NOT NULL,
    ds_email VARCHAR(255) NOT NULL,
    nr_telefone VARCHAR(15) NOT NULL
);

CREATE SEQUENCE conta_seq
    START WITH 783128
    INCREMENT BY 3
    NOCACHE
    NOCYCLE;

CREATE TABLE Conta (
    nr_conta NUMBER DEFAULT conta_seq.NEXTVAL PRIMARY KEY,
    nr_cpf VARCHAR2(11),
    vl_saldo NUMBER(20, 2),
    vl_fatura NUMBER(20, 2),
    vl_credito_limite NUMBER(20, 2),
    FOREIGN KEY (nr_cpf) REFERENCES Usuario(nr_cpf)
);

CREATE OR REPLACE TRIGGER trg_criar_conta
AFTER INSERT ON Usuario
FOR EACH ROW
BEGIN
    INSERT INTO Conta (nr_cpf, vl_saldo, vl_fatura, vl_credito_limite)
    VALUES (:NEW.nr_cpf, 30000, 0, 5000);
END;
/

ALTER TABLE CONTA
ADD CONSTRAINT chk_fatura_non_negative CHECK (vl_fatura >= 0);

ALTER TABLE CONTA
ADD CONSTRAINT chk_saldo_non_negative CHECK (vl_saldo >= 0);

ALTER TABLE CONTA
ADD CONSTRAINT chk_limite_non_negative CHECK (vl_limite >= 0);
```

⚠️ Remember: If there is any modification to the SQL commands, such as: changing the name of the tables or the name of the constraints, not executing a command, and among others, you will need to make the change in the Java code. Furthermore, the application may present unwanted or unexpected results.

👉🏼 It is recommended that a Tomcat 9.0 server is installed and configured on your machine.

😁 Thank you!
