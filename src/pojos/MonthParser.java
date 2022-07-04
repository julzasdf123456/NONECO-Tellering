/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author Julio Lopez
 */
public class MonthParser {
    private String sqlDate;
    private String readableDate;

    public MonthParser(String sqlDate, String readableDate) {
        this.sqlDate = sqlDate;
        this.readableDate = readableDate;
    }

    public String getSqlDate() {
        return sqlDate;
    }

    public void setSqlDate(String sqlDate) {
        this.sqlDate = sqlDate;
    }

    public String getReadableDate() {
        return readableDate;
    }

    public void setReadableDate(String readableDate) {
        this.readableDate = readableDate;
    }

    @Override
    public String toString() {
        return sqlDate;
    }
}
