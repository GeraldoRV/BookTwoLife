<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet 
    xmlns:xsl=
    "http://www.w3.org/1999/XSL/Transform" 
    version="1.0"
>

    <xsl:template match="screen">
        <HTML>
            <BODY bgcolor="white">
                <xsl:apply-templates/>
            </BODY>
        </HTML>
    </xsl:template>
    <xsl:template match="title">
        <h1>
            <xsl:apply-templates/>
        </h1>
    </xsl:template>
    <xsl:template match="table"> 
        <table>
             <xsl:apply-templates/>
        </table>
    </xsl:template>
    <xsl:template match="row"> 
       <tr> 
  
             <xsl:apply-templates/>
       
       </tr>
    </xsl:template>
    
    <xsl:template match="cell"> 
       <td> 
  
             <xsl:apply-templates/>
       
       </td>
    </xsl:template>
    
        <xsl:output method="html"/>

</xsl:stylesheet>