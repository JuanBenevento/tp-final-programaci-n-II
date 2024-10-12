package TpFinalProgramacion.DTOs;

import TpFinalProgramacion.Models.Invoices;
import TpFinalProgramacion.Models.Sales;

import java.util.Date;

public class InvoiceDTO {
    private int idInvoice;
    private Sales sale;
    private Date dateInvoice;
    private Double totalAmount;

    public InvoiceDTO(int idInvoice, Sales sale, Date dateInvoice, Double totalAmount) {
        this.idInvoice = idInvoice;
        this.sale = sale;
        this.dateInvoice = dateInvoice;
        this.totalAmount = totalAmount;
    }

    public InvoiceDTO (Invoices invoice){
        this.idInvoice = invoice.getIdInvoice();
        this.sale = invoice.getSale();
        this.dateInvoice = invoice.getDateInvoice();
        this.totalAmount = invoice.getTotalAmount();
    }

    public int getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
    }

    public Sales getSale() {
        return sale;
    }

    public void setSale(Sales sale) {
        this.sale = sale;
    }

    public Date getDateInvoice() {
        return dateInvoice;
    }

    public void setDateInvoice(Date dateInvoice) {
        this.dateInvoice = dateInvoice;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
