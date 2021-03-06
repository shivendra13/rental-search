//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.17 at 03:12:00 PM IST 
//


package src.main.java.generatable;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}searchKeyword"/&gt;
 *         &lt;element name="from_date" type="{}from_date"/&gt;
 *         &lt;element name="to_date" type="{}to_date"/&gt;
 *         &lt;element ref="{}lat"/&gt;
 *         &lt;element ref="{}lon"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "searchKeyword",
    "from_Date",
    "to_Date",
    "lat",
    "lon"
})
@XmlRootElement(name = "searchRequest")
public class SearchRequest
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String searchKeyword;
    @XmlElement(name = "from_date", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "date")
    protected Date from_Date;
    @XmlElement(name = "to_date", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "date")
    protected Date to_Date;
    protected double lat;
    protected double lon;

    /**
     * Gets the value of the searchKeyword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchKeyword() {
        return searchKeyword;
    }

    /**
     * Sets the value of the searchKeyword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchKeyword(String value) {
        this.searchKeyword = value;
    }

    /**
     * Gets the value of the from_Date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getFrom_Date() {
        return from_Date;
    }

    /**
     * Sets the value of the from_Date property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrom_Date(Date value) {
        this.from_Date = value;
    }

    /**
     * Gets the value of the to_Date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getTo_Date() {
        return to_Date;
    }

    /**
     * Sets the value of the to_Date property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTo_Date(Date value) {
        this.to_Date = value;
    }

    /**
     * Gets the value of the lat property.
     * 
     */
    public double getLat() {
        return lat;
    }

    /**
     * Sets the value of the lat property.
     * 
     */
    public void setLat(double value) {
        this.lat = value;
    }

    /**
     * Gets the value of the lon property.
     * 
     */
    public double getLon() {
        return lon;
    }

    /**
     * Sets the value of the lon property.
     * 
     */
    public void setLon(double value) {
        this.lon = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SearchRequest)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SearchRequest that = ((SearchRequest) object);
        {
            String lhsSearchKeyword;
            lhsSearchKeyword = this.getSearchKeyword();
            String rhsSearchKeyword;
            rhsSearchKeyword = that.getSearchKeyword();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "searchKeyword", lhsSearchKeyword), LocatorUtils.property(thatLocator, "searchKeyword", rhsSearchKeyword), lhsSearchKeyword, rhsSearchKeyword)) {
                return false;
            }
        }
        {
            Date lhsFrom_Date;
            lhsFrom_Date = this.getFrom_Date();
            Date rhsFrom_Date;
            rhsFrom_Date = that.getFrom_Date();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "from_Date", lhsFrom_Date), LocatorUtils.property(thatLocator, "from_Date", rhsFrom_Date), lhsFrom_Date, rhsFrom_Date)) {
                return false;
            }
        }
        {
            Date lhsTo_Date;
            lhsTo_Date = this.getTo_Date();
            Date rhsTo_Date;
            rhsTo_Date = that.getTo_Date();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "to_Date", lhsTo_Date), LocatorUtils.property(thatLocator, "to_Date", rhsTo_Date), lhsTo_Date, rhsTo_Date)) {
                return false;
            }
        }
        {
            double lhsLat;
            lhsLat = this.getLat();
            double rhsLat;
            rhsLat = that.getLat();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lat", lhsLat), LocatorUtils.property(thatLocator, "lat", rhsLat), lhsLat, rhsLat)) {
                return false;
            }
        }
        {
            double lhsLon;
            lhsLon = this.getLon();
            double rhsLon;
            rhsLon = that.getLon();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lon", lhsLon), LocatorUtils.property(thatLocator, "lon", rhsLon), lhsLon, rhsLon)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theSearchKeyword;
            theSearchKeyword = this.getSearchKeyword();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "searchKeyword", theSearchKeyword), currentHashCode, theSearchKeyword);
        }
        {
            Date theFrom_Date;
            theFrom_Date = this.getFrom_Date();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "from_Date", theFrom_Date), currentHashCode, theFrom_Date);
        }
        {
            Date theTo_Date;
            theTo_Date = this.getTo_Date();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "to_Date", theTo_Date), currentHashCode, theTo_Date);
        }
        {
            double theLat;
            theLat = this.getLat();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lat", theLat), currentHashCode, theLat);
        }
        {
            double theLon;
            theLon = this.getLon();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lon", theLon), currentHashCode, theLon);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        {
            String theSearchKeyword;
            theSearchKeyword = this.getSearchKeyword();
            strategy.appendField(locator, this, "searchKeyword", buffer, theSearchKeyword);
        }
        {
            Date theFrom_Date;
            theFrom_Date = this.getFrom_Date();
            strategy.appendField(locator, this, "from_Date", buffer, theFrom_Date);
        }
        {
            Date theTo_Date;
            theTo_Date = this.getTo_Date();
            strategy.appendField(locator, this, "to_Date", buffer, theTo_Date);
        }
        {
            double theLat;
            theLat = this.getLat();
            strategy.appendField(locator, this, "lat", buffer, theLat);
        }
        {
            double theLon;
            theLon = this.getLon();
            strategy.appendField(locator, this, "lon", buffer, theLon);
        }
        return buffer;
    }

}
