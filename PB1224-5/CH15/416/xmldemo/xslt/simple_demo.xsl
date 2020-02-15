<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
 <body>
   <h2 align="center">我喜歡的圖書</h2>
   <table border="1">
     <tr bgcolor="#55A0FF">
       <th>名稱</th>
       <th>出版社</th>
       <th>公司</th>
       <th>作者</th>
       <th>ISBN</th>
       <th>價格</th>
     </tr>
     <xsl:for-each select="books/book">
     <xsl:sort select="price"/>
     <tr>
       <td><xsl:value-of select="name"/></td>
       <td><xsl:value-of select="publisher"/></td>
       <td><xsl:value-of select="company"/></td>
       <td><xsl:value-of select="author"/></td>
       <td><xsl:value-of select="ISBN"/></td>
       <td><xsl:value-of select="price"/></td>
     </tr>
     <tr>
       <th bgcolor="#55A0FF" align="center">網站位址</th>
       <td colspan="5"><xsl:value-of select="url"/></td>
     </tr>
     </xsl:for-each>
   </table>
 </body>
 </html>
</xsl:template>
</xsl:stylesheet>
