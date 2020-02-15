<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
 <body>
   <table border="1">
     <tr>
       <td><xsl:value-of select="books/book/name"/></td>
       <td><xsl:value-of select="books/book/publisher"/></td>
       <td><xsl:value-of select="books/book/company"/></td>
       <td><xsl:value-of select="books/book/author"/></td>
       <td><xsl:value-of select="books/book/ISBN"/></td>
       <td><xsl:value-of select="books/book/price"/></td>
     </tr>
   </table>
 </body>
 </html>
</xsl:template>
</xsl:stylesheet>
