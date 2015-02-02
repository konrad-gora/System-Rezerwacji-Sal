<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing Uzytkownicy Items</title>
            <link rel="stylesheet" type="text/css" href="/tomcom/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing Uzytkownicy Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No Uzytkownicy Items Found)<br />" rendered="#{uzytkownicy.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{uzytkownicy.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{uzytkownicy.pagingInfo.firstItem + 1}..#{uzytkownicy.pagingInfo.lastItem} of #{uzytkownicy.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{uzytkownicy.prev}" value="Previous #{uzytkownicy.pagingInfo.batchSize}" rendered="#{uzytkownicy.pagingInfo.firstItem >= uzytkownicy.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{uzytkownicy.next}" value="Next #{uzytkownicy.pagingInfo.batchSize}" rendered="#{uzytkownicy.pagingInfo.lastItem + uzytkownicy.pagingInfo.batchSize <= uzytkownicy.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{uzytkownicy.next}" value="Remaining #{uzytkownicy.pagingInfo.itemCount - uzytkownicy.pagingInfo.lastItem}"
                                   rendered="#{uzytkownicy.pagingInfo.lastItem < uzytkownicy.pagingInfo.itemCount && uzytkownicy.pagingInfo.lastItem + uzytkownicy.pagingInfo.batchSize > uzytkownicy.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{uzytkownicy.uzytkownicyItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Id"/>
                            </f:facet>
                            <h:outputText value="#{item.id}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Login"/>
                            </f:facet>
                            <h:outputText value="#{item.login}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Imie"/>
                            </f:facet>
                            <h:outputText value="#{item.imie}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Nazwisko"/>
                            </f:facet>
                            <h:outputText value="#{item.nazwisko}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Haslo"/>
                            </f:facet>
                            <h:outputText value="#{item.haslo}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Email"/>
                            </f:facet>
                            <h:outputText value="#{item.email}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Pesel"/>
                            </f:facet>
                            <h:outputText value="#{item.pesel}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{uzytkownicy.detailSetup}">
                                <f:param name="jsfcrud.currentUzytkownicy" value="#{jsfcrud_class['src.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][uzytkownicy.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{uzytkownicy.editSetup}">
                                <f:param name="jsfcrud.currentUzytkownicy" value="#{jsfcrud_class['src.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][uzytkownicy.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{uzytkownicy.destroy}">
                                <f:param name="jsfcrud.currentUzytkownicy" value="#{jsfcrud_class['src.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][uzytkownicy.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{uzytkownicy.createSetup}" value="New Uzytkownicy"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
