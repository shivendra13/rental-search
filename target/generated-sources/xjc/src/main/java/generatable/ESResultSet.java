//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.10 at 07:37:06 PM IST 
//


package src.main.java.generatable;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element ref="{}took"/&gt;
 *         &lt;element ref="{}timed_out"/&gt;
 *         &lt;element ref="{}shards"/&gt;
 *         &lt;element ref="{}hit"/&gt;
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
    "took",
    "timed_Out",
    "shards",
    "hit"
})
@XmlRootElement(name = "ESResultSet")
public class ESResultSet
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected BigInteger took;
    @XmlElement(name = "timed_out")
    protected boolean timed_Out;
    @XmlElement(required = true)
    protected Shards shards;
    @XmlElement(required = true)
    protected Hit hit;

    /**
     * Gets the value of the took property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTook() {
        return took;
    }

    /**
     * Sets the value of the took property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTook(BigInteger value) {
        this.took = value;
    }

    /**
     * Gets the value of the timed_Out property.
     * 
     */
    public boolean isTimed_Out() {
        return timed_Out;
    }

    /**
     * Sets the value of the timed_Out property.
     * 
     */
    public void setTimed_Out(boolean value) {
        this.timed_Out = value;
    }

    /**
     * Gets the value of the shards property.
     * 
     * @return
     *     possible object is
     *     {@link Shards }
     *     
     */
    public Shards getShards() {
        return shards;
    }

    /**
     * Sets the value of the shards property.
     * 
     * @param value
     *     allowed object is
     *     {@link Shards }
     *     
     */
    public void setShards(Shards value) {
        this.shards = value;
    }

    /**
     * Gets the value of the hit property.
     * 
     * @return
     *     possible object is
     *     {@link Hit }
     *     
     */
    public Hit getHit() {
        return hit;
    }

    /**
     * Sets the value of the hit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Hit }
     *     
     */
    public void setHit(Hit value) {
        this.hit = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ESResultSet)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ESResultSet that = ((ESResultSet) object);
        {
            BigInteger lhsTook;
            lhsTook = this.getTook();
            BigInteger rhsTook;
            rhsTook = that.getTook();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "took", lhsTook), LocatorUtils.property(thatLocator, "took", rhsTook), lhsTook, rhsTook)) {
                return false;
            }
        }
        {
            boolean lhsTimed_Out;
            lhsTimed_Out = this.isTimed_Out();
            boolean rhsTimed_Out;
            rhsTimed_Out = that.isTimed_Out();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "timed_Out", lhsTimed_Out), LocatorUtils.property(thatLocator, "timed_Out", rhsTimed_Out), lhsTimed_Out, rhsTimed_Out)) {
                return false;
            }
        }
        {
            Shards lhsShards;
            lhsShards = this.getShards();
            Shards rhsShards;
            rhsShards = that.getShards();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "shards", lhsShards), LocatorUtils.property(thatLocator, "shards", rhsShards), lhsShards, rhsShards)) {
                return false;
            }
        }
        {
            Hit lhsHit;
            lhsHit = this.getHit();
            Hit rhsHit;
            rhsHit = that.getHit();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "hit", lhsHit), LocatorUtils.property(thatLocator, "hit", rhsHit), lhsHit, rhsHit)) {
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
            BigInteger theTook;
            theTook = this.getTook();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "took", theTook), currentHashCode, theTook);
        }
        {
            boolean theTimed_Out;
            theTimed_Out = this.isTimed_Out();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "timed_Out", theTimed_Out), currentHashCode, theTimed_Out);
        }
        {
            Shards theShards;
            theShards = this.getShards();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "shards", theShards), currentHashCode, theShards);
        }
        {
            Hit theHit;
            theHit = this.getHit();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "hit", theHit), currentHashCode, theHit);
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
            BigInteger theTook;
            theTook = this.getTook();
            strategy.appendField(locator, this, "took", buffer, theTook);
        }
        {
            boolean theTimed_Out;
            theTimed_Out = this.isTimed_Out();
            strategy.appendField(locator, this, "timed_Out", buffer, theTimed_Out);
        }
        {
            Shards theShards;
            theShards = this.getShards();
            strategy.appendField(locator, this, "shards", buffer, theShards);
        }
        {
            Hit theHit;
            theHit = this.getHit();
            strategy.appendField(locator, this, "hit", buffer, theHit);
        }
        return buffer;
    }

}
