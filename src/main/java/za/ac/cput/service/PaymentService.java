package za.ac.cput.service;

import za.ac.cput.domain.Payment;

import java.util.Set;

public interface PaymentService extends IService<Payment, String> {
    Payment create(Payment payment);

    Payment read(Integer paymentId);

    Payment update(Payment payment);

    boolean delete(int paymentId);

    Set<Payment> getAll();
}
