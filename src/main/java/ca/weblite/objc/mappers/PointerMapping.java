package ca.weblite.objc.mappers;

import ca.weblite.objc.TypeMapping;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.DoubleByReference;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.ptr.ShortByReference;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>PointerMapping class.</p>
 *
 * @author shannah
 * @version $Id: $Id
 * @since 1.1
 */
public class PointerMapping implements TypeMapping {
    
    Map<String,TypeMapping> mappers = new HashMap<String, TypeMapping>();
    
    /**
     * <p>Constructor for PointerMapping.</p>
     */
    public PointerMapping(){
        
        
        
    }

    /** {@inheritDoc} */
    @Override
    public Object cToJ(Object cVar, String signature, TypeMapping root) {
        if ( Pointer.class.isInstance(cVar)) return cVar;
        return new Pointer((Long)cVar);
    }

    /** {@inheritDoc} */
    @Override
    public Object jToC(Object jVar, String signature, TypeMapping root) {
        // After some difficult deliberation I've decided that it is 
        // better to require a Pointer or long to be passed in places
        // where Objective-C expects a pointer.
        return jVar;
    }
    
}
