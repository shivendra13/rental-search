//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.17 at 03:12:00 PM IST 
//


package src.main.java.generatable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
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
    "lat",
    "lon"
})
@XmlRootElement(name = "location")
public class Location
    implements Equals, HashCode, ToString
{

    protected double lat;
    protected double lon;

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
        if (!(object instanceof Location)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final Location that = ((Location) object);
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
