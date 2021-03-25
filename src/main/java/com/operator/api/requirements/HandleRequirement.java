package com.operator.api.requirements;

public abstract class HandleRequirement <X, Y> {

    public Y ejecutar(X request) {
        return run(request);
    }

    protected abstract Y run(X request);
}
