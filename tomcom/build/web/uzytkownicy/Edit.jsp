<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Editing Uzytkownicy</title>
            <link rel="stylesheet" type="text/css" href="/tomcom/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Editing Uzytkownicy</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Id:"/>
                    <h:outputText value="#{uzytkownicy.uzytkownicy.id}" title="Id" />
                    <h:outputText value="Login:"/>
                    <h:inputText id="login" value="#{uzytkownicy.uzytkownicy.login}" title="Login" required="true" requiredMessage="The login field is required." />
                    <h:outputText value="Imie:"/>
                    <h:inputText id="imie" value="#{uzytkownicy.uzytkownicy.imie}" title="Imie" required="true" requiredMessage="The imie field is required." />
                    <h:outputText value="Nazwisko:"/>
                    <h:inputText id="nazwisko" value="#{uzytkownicy.uzytkownicy.nazwisko}" title="Nazwisko" required="true" requiredMessage="The nazwisko field is required." />
                    <h:outputText value="Haslo:"/>
                    <h:inputText id="haslo" value="#{uzytkownicy.uzytkownicy.haslo}" title="Haslo" required="true" requiredMessage="The haslo field is required." />
                    <h:outputText value="Email:"/>
                    <h:inputText id="email" value="#{uzytkownicy.uzytkownicy.email}" title="Email" required="true" requiredMessage="The email field is required." />
                    <h:outputText value="Pesel:"/>
                    <h:inputText id="pesel" value="#{uzytkownicy.uzytkownicy.pesel}" title="Pesel" required="true" requiredMessage="The pesel field is required." />

                </h:panelGrid>
                <br />
                <h:commandLink action="#{uzytkownicy.edit}" value="Save">
                    <f:param name="jsfcrud.currentUzytkownicy" value="#{jsfcrud_class['src.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][uzytkownicy.uzytkownicy][uzytkownicy.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{uzytkownicy.detailSetup}" value="Show" immediate="true">
                    <f:param name="jsfcrud.currentUzytkownicy" value="#{jsfcrud_class['src.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][uzytkownicy.uzytkownicy][uzytkownicy.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{uzytkownicy.listSetup}" value="Show All Uzytkownicy Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
