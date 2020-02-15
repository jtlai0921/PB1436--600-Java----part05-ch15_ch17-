<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" version="4.0" encoding="iso-8859-1"
		indent="yes" />

	<xsl:template match="/">
		<html>
			<body>
				<xsl:element name="h2">
					我喜歡的圖書
				</xsl:element>

				<xsl:for-each select="books/book">
					<p>
						<xsl:value-of select="name" /> <a href="#{generate-id(name)}">檢視詳細</a> 
					</p>
				</xsl:for-each>
					<hr/>
				<xsl:for-each select="books/book">
					<p>
						<a name="#{generate-id(name)}"><xsl:value-of select="name" /></a>
					</p>
					<p>
						<xsl:value-of select="publisher" />
					</p>
					<p>
						<xsl:value-of select="company" />
					</p>
					<p>
						<xsl:value-of select="author" />
					</p>
					<p>
						<xsl:value-of select="ISBN" />
					</p>
					<p>
						<xsl:value-of select="price" />
					</p>
					<p>
						<xsl:value-of select="url" />
					</p>
					<hr/>
				</xsl:for-each>

			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
