<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>

<head>
    <title>Calculadora</title>
    <meta charset="UTF-8">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css" />
    <%@ page contentType="text/html; charset=UTF-8" %>
        <script>
            function calcular() {
                var operando1 = document.getElementById("campoOperando1").value;
                var operador = document.getElementById("Operadores").value;
                var operando2 = document.getElementById("campoOperando2").value;

                var formData = {
                    operando1: operando1,
                    operando2: operando2,
                    operador: operador,
                }

                $.post("/calculadora/calc", formData, function(data, status) {
                    listarResultados();
                });
            }

            function listarResultados() {
                $.get("/calculadora/resultado", function(data, status) {
                    var divHistorico = document.getElementById('historico')
                    divHistorico.textContent = ''
                    data.forEach(element => {
                        var pElem = document.createElement('p');
                        pElem.innerHTML = element.operacao + ' = ' + element.resultado + ' - ' + element.data;
                        console.log(element)
                        divHistorico.appendChild(pElem);
                    });

                });
            }
            $(document).ready(function() {
                listarResultados();
            })
        </script>
</head>

<body>
    <div class="container4">
        <section>

    </div>
    <div class="elemento2">
        <label for="campoOperando1">Operando 1</label>
        <input name="campoOperando1" id="campoOperando1" type="text" onkeypress="return event.charCode >= 48 && event.charCode <= 57">
        <label for="Operadores">Escolha a operação:</label>
        <select name="Operadores" id="Operadores">
            <option value="1">+</option>
            <option value="2">-</option>
            <option value="3">x</option>
            <option value="4">&divide;</option>
            <option value="5">&radic;</option>
            <option value="6">Potência</option>
        </select>
        <label for="campoOperando2">Operando 2</label>
        <input name="campoOperando2" id="campoOperando2" type="text" onkeypress="return event.charCode >= 48 && event.charCode <= 57">
        <button onclick="calcular()">Calcular</button>
        </section>

        <section>
            <h2>
                Histórico/Resultado
            </h2>
            <div id="historico">

            </div>
    </div>
    </section>

</body>

</html>