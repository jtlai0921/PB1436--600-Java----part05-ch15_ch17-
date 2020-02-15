<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
 <body>
   <xsl:apply-templates/>
 </body>
 </html>
</xsl:template>

<xsl:template  match="book">
<xsl:apply-templates select="name"/>
<xsl:apply-templates select="ISBN"/>
<xsl:apply-templates select="price"/>
<br/>
</xsl:template>

<xsl:template match="name">
<span style="color:#00008b">名稱:<xsl:value-of select="."/></span>
<br/>
</xsl:template>
<xsl:template match="price">
<span style="color:#8b008b">價格: <xsl:value-of select="."/></span>
<br/>
</xsl:template>
<xsl:template match="ISBN">
<span style="color:#2f4f4f">ISBN: <xsl:value-of select="."/></span>
<br/>
</xsl:template>
</xsl:stylesheet>
