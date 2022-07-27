package jdk.proxy1;

import com.chance.reflection.proxy.Subject;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

/* renamed from: jdk.proxy1.$Proxy0  reason: invalid class name */
/* loaded from: $Proxy0.class */
public final class C$Proxy0 extends Proxy implements Subject {
    private static final Method m0;
    private static final Method m1;
    private static final Method m2;
    private static final Method m3;
    private static final Method m4;

    public C$Proxy0(InvocationHandler invocationHandler) {
        super(invocationHandler);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Throwable, int] */
    public final int hashCode() {
        ?? intValue;
        try {
            try {
                intValue = ((Integer) ((Proxy) this).h.invoke(this, m0, null)).intValue();
                return intValue;
            } catch (Error | RuntimeException unused) {
                throw intValue;
            }
        } catch (Throwable th) {
            throw new UndeclaredThrowableException(th);
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Throwable, boolean] */
    public final boolean equals(Object obj) {
        ?? booleanValue;
        try {
            try {
                booleanValue = ((Boolean) ((Proxy) this).h.invoke(this, m1, new Object[]{obj})).booleanValue();
                return booleanValue;
            } catch (Throwable th) {
                throw new UndeclaredThrowableException(th);
            }
        } catch (Error | RuntimeException unused) {
            throw booleanValue;
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Throwable, java.lang.String] */
    public final String toString() {
        ?? r0;
        try {
            try {
                r0 = (String) ((Proxy) this).h.invoke(this, m2, null);
                return r0;
            } catch (Error | RuntimeException unused) {
                throw r0;
            }
        } catch (Throwable th) {
            throw new UndeclaredThrowableException(th);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Throwable, java.lang.Object] */
    public final void rent() {
        ?? invoke;
        try {
            try {
                invoke = ((Proxy) this).h.invoke(this, m3, null);
            } catch (Error | RuntimeException unused) {
                throw invoke;
            }
        } catch (Throwable th) {
            throw new UndeclaredThrowableException(th);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Throwable, java.lang.Object] */
    public final void hello(String str) {
        ?? invoke;
        try {
            try {
                invoke = ((Proxy) this).h.invoke(this, m4, new Object[]{str});
            } catch (Error | RuntimeException unused) {
                throw invoke;
            }
        } catch (Throwable th) {
            throw new UndeclaredThrowableException(th);
        }
    }

    static {
        try {
            m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
            m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
            m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
            m3 = Class.forName("com.chance.reflection.proxy.Subject").getMethod("rent", new Class[0]);
            m4 = Class.forName("com.chance.reflection.proxy.Subject").getMethod("hello", Class.forName("java.lang.String"));
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        } catch (NoSuchMethodException e2) {
            throw new NoSuchMethodError(e2.getMessage());
        }
    }

    private static MethodHandles.Lookup proxyClassLookup(MethodHandles.Lookup lookup) throws IllegalAccessException {
        if (lookup.lookupClass() != Proxy.class || !lookup.hasFullPrivilegeAccess()) {
            throw new IllegalAccessException(lookup.toString());
        }
        return MethodHandles.lookup();
    }
}