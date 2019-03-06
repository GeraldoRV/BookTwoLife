<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
    xmlns:xsl=
    "http://www.w3.org/1999/XSL/Transform" 
    version="1.0"
>

    <xsl:template match="/">
        <html>
            <body>
                <h1>
                    <xsl:value-of select="book/name"/>
                </h1>
                <h1>
                    <xsl:value-of select="book/description"/>
                </h1>
                <h1>
                    <xsl:value-of select="book/genre"/>
                </h1>
                <h1>
                    <xsl:value-of select="book/price"/>
                </h1>
            </body>
        </html>
    </xsl:template>

  
</xsl:stylesheet>