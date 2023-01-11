package com.github.mouse0w0.observable.value;

import com.github.mouse0w0.observable.InvalidationListener;

public class ReadOnlyBooleanWrapper extends SimpleBooleanValue implements WritableValue<Boolean> {

    private ReadOnlyBooleanValue readOnlyBooleanValue;

    public ReadOnlyBooleanWrapper() {
    }

    public ReadOnlyBooleanWrapper(boolean value) {
        super(value);
    }

    public ObservableBooleanValue toReadOnly() {
        if (readOnlyBooleanValue == null)
            readOnlyBooleanValue = new ReadOnlyBooleanValue();
        return readOnlyBooleanValue;
    }

    private class ReadOnlyBooleanValue implements ObservableBooleanValue {
        @Override
        public boolean get() {
            return ReadOnlyBooleanWrapper.this.get();
        }

        @Override
        public Boolean getValue() {
            return ReadOnlyBooleanWrapper.this.getValue();
        }

        @Override
        public void addListener(InvalidationListener listener) {
            ReadOnlyBooleanWrapper.this.addListener(listener);
        }

        @Override
        public void removeListener(InvalidationListener listener) {
            ReadOnlyBooleanWrapper.this.removeListener(listener);
        }

        @Override
        public void addListener(ChangeListener<? super Boolean> listener) {
            ReadOnlyBooleanWrapper.this.addListener(listener);
        }

        @Override
        public void removeListener(ChangeListener<? super Boolean> listener) {
            ReadOnlyBooleanWrapper.this.removeListener(listener);
        }

        @Override
        public String toString() {
            return "ReadOnlyBooleanValue{" +
                    "value=" + ReadOnlyBooleanWrapper.this.get() +
                    '}';
        }


    }
}
