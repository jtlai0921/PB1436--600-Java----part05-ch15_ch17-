<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
 <body>
   <table>
     <tr bgcolor="#8E8E8E">
       <td>名稱</td>
       <td>出版社</td>
       <td>出版公司</td>
       <td>作者</td>
       <td>ISBN號</td>
       <td>價格</td>
     </tr>
   <xsl:for-each select="books/book">
   	<xsl:choose>
       <xsl:when test="(price &lt; 50)">
	     <tr bgcolor="#CDCD9A">
	       <td><xsl:value-of select="name"/></td>
	       <td><xsl:value-of select="publisher"/></td>
	       <td><xsl:value-of select="company"/></td>
	       <td><xsl:value-of select="author"/></td>
	       <td><xsl:value-of select="ISBN"/></td>
	       <td><xsl:value-of select="price"/></td>
	     </tr>
       </xsl:when>
       <xsl:when test="(price &lt;= 65)" >
	     <tr bgcolor="#A5A552">
	       <td><xsl:value-of select="name"/></td>
	       <td><xsl:value-of select="publisher"/></td>
	       <td><xsl:value-of select="company"/></td>
	       <td><xsl:value-of select="author"/></td>
	       <td><xsl:value-of select="ISBN"/></td>
	       <td><xsl:value-of select="price"/></td>
	     </tr>
       </xsl:when>
		<xsl:otherwise>
	     <tr bgcolor="#616130">
	       <td><xsl:value-of select="name"/></td>
	       <td><xsl:value-of select="publisher"/></td>
	       <td><xsl:value-of select="company"/></td>
	       <td><xsl:value-of select="author"/></td>
	       <td><xsl:value-of select="ISBN"/></td>
	       <td><xsl:value-of select="price"/></td>
	     </tr>
		</xsl:otherwise>
  	</xsl:choose>     
    </xsl:for-each> 
   </table>
 </body>
 </html>
</xsl:template>
</xsl:stylesheet>
