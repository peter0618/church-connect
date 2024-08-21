package com.churchconnect.domain.member;

import static com.churchconnect.common.util.DateTimeUtil.convertToYMD;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MemberExcelFile {

    private final List<MemberEntity> list;
    private final Workbook wb;
    private final int ROW_START_INDEX = 0;
    private final int COLUMN_START_INDEX = 0;
    private final String[] headers = {"이름", "성별", "직분", "셀", "전화번호", "생년월일", "주소", "가족관계", "비고", "등록일"};

    public MemberExcelFile(List<MemberEntity> list) {
        this.list = list;
        wb = new XSSFWorkbook();
        renderExcel();
    }

    private void renderExcel() {
        Sheet sheet = wb.createSheet("회원 목록");
        renderHeaders(sheet, ROW_START_INDEX, COLUMN_START_INDEX);
        renderBodies(sheet, ROW_START_INDEX, COLUMN_START_INDEX);
        autoSizing(sheet);
    }

    //셀 넓이 자동 조정
    private void autoSizing(Sheet sheet) {
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
            sheet.setColumnWidth(i, sheet.getColumnWidth(i));
        }
    }

    private void renderBodies(Sheet sheet, int rowStartIndex, int colStartIndex) {
        int rowIndex = rowStartIndex + 1;
        Row row;
        Cell cell;

        for (MemberEntity memberEntity : list) {
            row = sheet.createRow(rowIndex++);
            int colIndex = colStartIndex;

            cell = row.createCell(colIndex++);
            cell.setCellValue(memberEntity.getName());

            cell = row.createCell(colIndex++);
            cell.setCellValue(memberEntity.getGender().getKoreanName());

            cell = row.createCell(colIndex++);
            cell.setCellValue(memberEntity.getPosition());

            cell = row.createCell(colIndex++);
            cell.setCellValue(memberEntity.getCellName());

            cell = row.createCell(colIndex++);
            cell.setCellValue(memberEntity.getPhoneNumber());

            cell = row.createCell(colIndex++);
            cell.setCellValue(convertToYMD(memberEntity.getBirthDate()));

            cell = row.createCell(colIndex++);
            cell.setCellValue(memberEntity.getAddress());

            cell = row.createCell(colIndex++);
            cell.setCellValue(memberEntity.getFamilyInfo());

            cell = row.createCell(colIndex++);
            cell.setCellValue(memberEntity.getNote());

            cell = row.createCell(colIndex++);
            cell.setCellValue(convertToYMD(memberEntity.getRegistrationDate()));
        }
    }

    private void renderHeaders(Sheet sheet, int rowStartIndex, int colStartIndex) {
        Row row = sheet.createRow(rowStartIndex);
        int colIndex = colStartIndex;
        Cell cell;

        for (String header : headers) {
            cell = row.createCell(colIndex++);
            cell.setCellValue(header);
        }
    }

    public void write(OutputStream stream) throws IOException {
        wb.write(stream);
        wb.close();
        stream.close();
    }
}
