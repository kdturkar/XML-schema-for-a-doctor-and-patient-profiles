<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>
                    Hospital Record
                </title>
                <link rel="stylesheet" href="mystyle.css"></link>
            </head>
            <body>
                <table border="3px" class="demotbl">
                    <tr>
                        <th>
                            Id
                        </th>
                        <th>
                            Doctor
                        </th>
                        <th>
                            Address
                        </th>
                        <th>
                            Contact No.
                        </th>
                        <th>
                            DOB
                        </th>
                        <th>
                            Specialization
                        </th>
                        <th>
                            PatientAppointments
                        </th>
                    </tr>
                    <xsl:for-each select="Hospital/Doctors/Doctor">
                        <tr>
                            <td>
                                <xsl:value-of select="@D_Id" />
                            </td>
                            <td>
                                <xsl:value-of select="Doctor_Name" />
                            </td>
                            <td>
                                <xsl:value-of select="DoctorContact/DoctorAddress" />
                            </td>
                            <td>
                                <xsl:for-each select="DoctorContact/DoctorPhone">
                                    <xsl:value-of select="." />
                                </xsl:for-each>
                            </td>
                            <td>
                                <xsl:value-of select="DOB" />
                            </td>
                            <td>
                                <xsl:value-of select="Specialization" />
                            </td>
                            <td>
                                <xsl:variable name="count1" select="0" />
                                <xsl:variable name="count2" select="0" />
                                <xsl:for-each select="Hospital/Appointments/Appointment">

                                    <xsl:variable name="DrId" select="AppointedDoctor/@AppointedDoctorId" />

                                        <xsl:if test="$DrId=01">
                                           <xsl:variable name="count1" select="1 + $count1" />
                                               <xsl:value-of select="$count1" />
                                        </xsl:if>

                                        <xsl:if test="$DrId=02">
                                           <xsl:variable name="count2" select="1 + $count2" />
                                               <xsl:value-of select="$count2" />
                                        </xsl:if>
                                        
                                </xsl:for-each>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
                <br />
                <br />
                <table border="3px" class="demotbl">
                    <tr>
                        <th>
                            Id
                        </th>
                        <th>
                            Patient
                        </th>
                        <th>
                            Address
                        </th>
                        <th>
                            Contact No.
                        </th>
                        <th>
                            DOB
                        </th>
                        <th>
                            Attended By
                        </th>
                        <th>
                            Illness
                        </th>
                    </tr>
                    <xsl:for-each select="Hospital/Patients/Patient">
                        <tr>
                            <td>
                                <xsl:value-of select="@P_Id" />
                            </td>
                            <td>
                                <xsl:value-of select="Patient_Name" />
                            </td>
                            <td>
                                <xsl:value-of select="PatientContact/PatientAddress" />
                            </td>
                            <td>
                                <xsl:for-each select="PatientContact/PatientPhone">
                                    <xsl:value-of select="." />
                                </xsl:for-each>
                            </td>
                            <td>
                                <xsl:value-of select="DOB" />
                            </td>
                            <td>
                                <xsl:value-of select="AttendedDoctor/@AttendedBy" />
                            </td>
                            <td>
                                <xsl:value-of select="Illness" />
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
                <br />
                <br />
                <table border="3px" class="demotbl">
                    <tr>
                        <th>
                            AppointmentId
                        </th>
                        <th>
                            AppointmentDoctorId
                        </th>
                        <th>
                            AppointmentPatientId
                        </th>
                        <th>
                            ApppointmentDate
                        </th>
                        <th>
                            AppointmentTime
                        </th>
                        <th>
                            PatientCondition
                        </th>
                    </tr>
                    <xsl:for-each select="Hospital/Appointments/Appointment">
                        <tr>
                            <td>
                                <xsl:value-of select="@AppointmentId" />
                            </td>
                            <td>
                                <xsl:value-of select="AppointedDoctor/@AppointedDoctorId" />
                            </td>
                            <td>
                                <xsl:value-of select="AppointedPatient/@AppointedPatientId" />
                            </td>
                            <td>
                                <xsl:value-of select="AppointedDate/@AppointmentDate" />
                            </td>
                            <td>
                                <xsl:value-of select="AppointedTime/@AppointmentTime" />
                            </td>
                            <td>
                                <xsl:value-of select="PatientCondition" />
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>