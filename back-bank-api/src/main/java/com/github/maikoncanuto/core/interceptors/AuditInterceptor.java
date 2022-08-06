package com.github.maikoncanuto.core.interceptors;

import com.github.maikoncanuto.core.annotations.Audit;
import org.jboss.logging.Logger;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import static com.github.maikoncanuto.domain.enums.MessageEnum.*;
import static java.lang.String.format;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Stream.of;
import static org.jboss.logging.Logger.getLogger;

@Audit
@Interceptor
@Priority(1)
public class AuditInterceptor {

    private static final Logger LOG = getLogger(AuditInterceptor.class);

    @AroundInvoke
    public Object intercept(final InvocationContext invocationContext) throws Exception {
        final var nameMethod = invocationContext.getMethod().getName();
        final var params = of(invocationContext.getParameters()).map(param -> format("%s, ", param)).collect(joining());

        try {
            LOG.info(format(INTERCEPTOR_METODO_EXECUTADO.get(), nameMethod, params));
            final var process = invocationContext.proceed();
            LOG.info(format(INTERCEPTOR_METODO_FIM_EXECUTADO.get(), nameMethod));
            return process;
        } catch (final Exception e) {
            LOG.error(format(INTERCEPTOR_METODO_PROBLEMA.get(), nameMethod, params, e.getMessage()), e);
            throw e;
        }
    }
}
