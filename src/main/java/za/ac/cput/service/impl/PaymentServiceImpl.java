// Payment Service Impl Class.java
// Author: Sobantu Malotana (220472122)
// Date: 07 June 2023

package za.ac.cput.service.impl;

import za.ac.cput.domain.Payment;
import za.ac.cput.repository.PaymentRepository;
import za.ac.cput.service.PaymentService;

import java.util.Set;

public abstract class PaymentServiceImpl implements PaymentService {


    private static PaymentServiceImpl  service = null;

    private static PaymentRepository repository = null;

    private PaymentServiceImpl () {
        repository = PaymentServiceImpl.getRepository();
    }

    public static PaymentRepository getRepository() {
       // repository = PaymentServiceImpl.getRepository();
        return null;
    }

    public static PaymentServiceImpl getService() {
        if (service == null) service = new PaymentServiceImpl() {
            @Override
            public Payment read(String s) {
                return null;
            }

            @Override
            public boolean delete() {
                return false;
            }
        };
        return service;
    }

    @Override
    public Payment create(Payment payment) {
        Payment created = repository.create(payment);
        return created;
    }
    @Override
    public Payment read(Integer paymentId) {
        Payment readPayment = repository.read(paymentId);
        return readPayment;
    }
    @Override
    public Payment update(Payment payment) {
        Payment updated = repository.update(payment);
        return updated;
    }

    @Override
    public boolean delete(int paymentId) {
        boolean success = repository.delete(Integer.parseInt(String.valueOf(paymentId)));
        return success;
    }
    @Override
    public Set<Payment> getAll(){return repository.getAll();}
}

