package com.github.mouse0w0.observable.value;

import com.github.mouse0w0.observable.InvalidationListener;

public class SimpleFloatValue implements WritableFloatValue, ObservableValue<Float> {
    private boolean valid = true;
    private float value;
    private ListenerHelper<Float> listenerHelper;

    public SimpleFloatValue() {
    }

    public SimpleFloatValue(float value) {
        this.value = value;
    }

    @Override
    public void addListener(InvalidationListener listener) {
        listenerHelper = ListenerHelper.addListener(this, listenerHelper, listener);
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        listenerHelper = ListenerHelper.removeListener(listenerHelper, listener);
    }

    @Override
    public void addListener(ChangeListener<? super Float> listener) {
        listenerHelper = ListenerHelper.addListener(this, listenerHelper, listener);
    }

    @Override
    public void removeListener(ChangeListener<? super Float> listener) {
        listenerHelper = ListenerHelper.removeListener(listenerHelper, listener);
    }

    protected void invalidate() {
        if (valid) {
            valid = false;
            ListenerHelper.fire(listenerHelper);
        }
    }

    @Override
    public float get() {
        valid = true;
        return value;
    }

    @Override
    public void set(float value) {
        if (this.value != value) {
            this.value = value;
            invalidate();
        }
    }

    @Override
    public void setValue(Float value) {
        set(value);
    }

    @Override
    public String toString() {
        return "SimpleFloatValue{" +
                "value=" + value +
                '}';
    }
}
