<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
    xmlns:xsl=
    "http://www.w3.org/1999/XSL/Transform" 
    version="1.0"
>

    <xsl:template match="book">
        <html>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="price">
        <h2>Precio</h2>
        <xsl:apply-templates/>
    </xsl:template>
    <xsl:template match="description">
        <h2>Descripcion</h2>
        <xsl:apply-templates/>
        
    </xsl:template>
    <xsl:template match="name">
        <h2>Nombre</h2>
        <xsl:apply-templates/>
        
    </xsl:template>
    <xsl:template match="genre">
        <h2>Genero</h2>
        <xsl:apply-templates/>
        
    </xsl:template>

  
</xsl:stylesheet>
