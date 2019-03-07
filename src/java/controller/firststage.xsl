<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet 
    xmlns:xsl=
    "http://www.w3.org/1999/XSL/Transform" 
    version="1.0"
>

    <xsl:template match="pageSeller">
        <screen>
            <xsl:apply-templates/>
        </screen>
    </xsl:template>
    <xsl:template match="pageSeller/sellerName">
        <title>
            <xsl:apply-templates/>
        </title>
    </xsl:template>
 
    <xsl:template match="bookList">
        <table>
            <xsl:apply-templates/>
        </table>
    </xsl:template>
    <xsl:template match="book">
        <row>
            <xsl:apply-templates/>
        </row>
    </xsl:template> 
    <xsl:template match="book/description">
        <cell>
            <xsl:apply-templates/>
        </cell>
    </xsl:template> 
    <xsl:template match="book/genre">
        <cell>
            <xsl:apply-templates/>
        </cell>
    </xsl:template> 
    <xsl:template match="book/price">
        <cell>
            <xsl:apply-templates/>
        </cell>
    </xsl:template> 
    <xsl:template match="book/name">
        <cell>
            <xsl:apply-templates/>
        </cell>
    </xsl:template> 
</xsl:stylesheet>