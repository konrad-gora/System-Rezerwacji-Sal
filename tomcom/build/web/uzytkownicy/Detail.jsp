<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Uzytkownicy Detail</title>
            <link rel="stylesheet" type="text/css" href="/tomcom/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Uzytkownicy Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="Id:"/>
                    <h:outputText value="#{uzytkownicy.uzytkownicy.id}" title="Id" />
                    <h:outputText value="Login:"/>
                    <h:outputText value="#{uzytkownicy.uzytkownicy.login}" title="Login" />
                    <h:outputText value="Imie:"/>
                    <h:outputText value="#{uzytkownicy.uzytkownicy.imie}" title="Imie" />
                    <h:outputText value="Nazwisko:"/>
                    <h:outputText value="#{uzytkownicy.uzytkownicy.nazwisko}" title="Nazwisko" />
                    <h:outputText value="Haslo:"/>
                    <h:outputText value="#{uzytkownicy.uzytkownicy.haslo}" title="Haslo" />
                    <h:outputText value="Email:"/>
                    <h:outputText value="#{uzytkownicy.uzytkownicy.email}" title="Email" />
                    <h:outputText value="Pesel:"/>
                    <h:outputText value="#{uzytkownicy.uzytkownicy.pesel}" title="Pesel" />


                </h:panelGrid>
                <br />
                <h:commandLink action="#{uzytkownicy.destroy}" value="Destroy">
                    <f:param name="jsfcrud.currentUzytkownicy" value="#{jsfcrud_class['src.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][uzytkownicy.uzytkownicy][uzytkownicy.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{uzytkownicy.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentUzytkownicy" value="#{jsfcrud_class['src.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][uzytkownicy.uzytkownicy][uzytkownicy.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{uzytkownicy.createSetup}" value="New Uzytkownicy" />
                <br />
                <h:commandLink action="#{uzytkownicy.listSetup}" value="Show All Uzytkownicy Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
