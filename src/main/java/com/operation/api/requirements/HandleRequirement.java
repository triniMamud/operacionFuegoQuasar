package com.operation.api.requirements;

public abstract class HandleRequirement <X, Y> {

    public Y ejecutar(X request) {
        return run(request);
    }

    protected abstract Y run(X request);
}
