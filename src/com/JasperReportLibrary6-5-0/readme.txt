
JasperReports Library 6.5.0 Change Log
=============================================

- support for configuration properties with the net.sf.jasperreports.export.xls.pattern.{arbitrary_pattern}
format to allow more flexible and reusable mapping between Java and Excel cell format patterns 
for the XLS/XLSX exporters;

- solved various band evaluation issues related to page/column level totals 
displayed in page/column footers when page/column breaks are introduced by 
stretching bands which are prevented from splitting;

- inhibit the creation of new page/column when the current page/column is already 
new and thus avoid creating empty pages/columns in various cases where features 
for controlling page/column breaks were involved;

- added more test reports to document the changes in the way band evaluation and 
page/column breaks work;

- minor bug fixes and improvements;
