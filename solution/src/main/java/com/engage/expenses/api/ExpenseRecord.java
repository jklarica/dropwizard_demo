package com.engage.expenses.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A class representing a single expense record
 *
 * @author jklarica
 * @since 2018-02-10
 */
@JsonPropertyOrder({ "id", "date", "amount", "reason", "country" })
public class ExpenseRecord
{
    @JsonProperty("id")
    private int m_id;

    @JsonProperty("date")
    @NotNull
    private LocalDate m_date;

    @JsonProperty("amount")
    @NotNull @Range(min = 1)
    private BigDecimal m_amount;

    @JsonProperty("reason")
    @NotEmpty
    private String m_reason;

    @JsonProperty("country")
    @NotEmpty
    private String m_country;

    ExpenseRecord() {
    }

    ExpenseRecord(int id, LocalDate date, BigDecimal amount, String reason)
    {
        m_id = id;
        m_date = date;
        m_amount = amount;
        m_reason = reason;
    }

    public ExpenseRecord(LocalDate date, BigDecimal amount, String reason, String country)
    {
        m_date = date;
        m_amount = amount;
        m_reason = reason;
        m_country = country;
    }

    public int getId()
    {
        return m_id;
    }

    public void setId(int id)
    {
        m_id = id;
    }

    public LocalDate getDate()
    {
        return m_date;
    }

    public void setDate(final LocalDate date)
    {
        m_date = date;
    }

    public BigDecimal getAmount()
    {
        return m_amount;
    }

    public void setAmount(final BigDecimal amount)
    {
        m_amount = amount;
    }

    public String getReason()
    {
        return m_reason;
    }

    public void setReason(final String reason)
    {
        m_reason = reason;
    }

    public String getCountry()
    {
        return m_country;
    }

    public void setCountry(String country)
    {
        m_country = country;
    }

    @Override public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ExpenseRecord that = (ExpenseRecord) o;
        return m_id == that.m_id &&
            Objects.equals(m_date, that.m_date) &&
            Objects.equals(m_amount, that.m_amount) &&
            Objects.equals(m_reason, that.m_reason) &&
            Objects.equals(m_country, that.m_country);
    }

    @Override public int hashCode()
    {
        return Objects.hash(m_id, m_date, m_amount, m_reason, m_country);
    }

    @Override public String toString()
    {
        return "ExpenseRecord{" +
            "m_id=" + m_id +
            ", m_date=" + m_date +
            ", m_amount=" + m_amount +
            ", m_reason='" + m_reason + '\'' +
            ", m_country='" + m_country + '\'' +
            '}';
    }
}