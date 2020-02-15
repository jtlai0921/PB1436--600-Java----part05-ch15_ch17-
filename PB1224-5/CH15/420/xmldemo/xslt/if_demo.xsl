<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
 <body>
   <table border="1">
     <tr>
       <td>名稱</td>
       <td>出版社</td>
       <td>出版公司</td>
       <td>作者</td>
       <td>ISBN號</td>
       <td>價格</td>
     </tr>
   <xsl:for-each select="books/book">
	<xsl:if test="author = '梁冰'">
	     <tr bgcolor="#7D7DFF">
	       <td><xsl:value-of select="name"/></td>
	       <td><xsl:value-of select="publisher"/></td>
	       <td><xsl:value-of select="company"/></td>
	       <td><xsl:value-of select="author"/></td>
	       <td><xsl:value-of select="ISBN"/></td>
	       <td><xsl:value-of select="price"/></td>
	     </tr>
     </xsl:if>
	<xsl:if test="author != '梁冰'">
	     <tr bgcolor="#FFFF6F">
	       <td><xsl:value-of select="name"/></td>
	       <td><xsl:value-of select="publisher"/></td>
	       <td><xsl:value-of select="company"/></td>
	       <td><xsl:value-of select="author"/></td>
	       <td><xsl:value-of select="ISBN"/></td>
	       <td><xsl:value-of select="price"/></td>
	     </tr>
     </xsl:if>
    </xsl:for-each> 
   </table>
 </body>
 </html>
</xsl:template>
</xsl:stylesheet>
