package com.test

import java.time.LocalTime
import java.time.format.DateTimeFormatter

fun main() {


    println(test1())
    println(test2())

}

private fun convertDays(num: Int): String {
    return when(num){
        1 -> "понедельникам"
        2 -> "вторникам"
        3 -> "средам"
        4 -> "четвергам"
        5 -> "пятницам"
        6 -> "субботам"
        7 -> "воскресеньям"
        else -> ""
    }
}

private fun test1(): String {
    val builder = StringBuilder()

    builder.append("<div>Служба уведомлений<br/>сервиса CRM {context.organization}</div>")
    builder.append("<div><span><br/></span></div>")
    builder.append("<div><span style=\"font-size: 11px; color: #777777;\">Это письмо - часть процесса доставки комментариев и сообщений сервиса CRM {context.organization}</span></div>")
    builder.append("<div><span style=\"font-size: 11px; color: #777777;\">Вы получили это письмо, так как являетесь пользователем сервиса CRM {context.organization}. " +
            "Чтобы контролировать входящие сообщения, " +
            "<a href=\"{context.domain}/#/crm/profile/notification\">измените настройки в своем профиле.</a></span></div>")

    return builder.toString()
}

private fun test2(): String {
    val builder = StringBuilder()

    builder.append("<div>Служба уведомлений<br/>сервиса CRM {context.organization}</div>")
    builder.append("<div><span><br/></span></div>")
    builder.append("<div><span style=\"font-size: 11px; color: #777777;\">Это письмо - часть процесса доставки комментариев и сообщений сервиса CRM {context.organization}</span></div>")
    builder.append("<div><span style=\"font-size: 11px; color: #777777;\">Вы получили это письмо, так как являетесь пользователем сервиса CRM {context.organization}. " +
            "Чтобы контролировать входящие сообщения, " +
            "<a href=\"{context.domain}/#/crm/profile/notification\">измените настройки в своем профиле.</a></span></div>")

    return """
            <table class="nl-container" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace:0;mso-table-rspace:0;background-color:#fff">
              <tbody>
                <tr>
                  <td>
                    <table class="row row-1" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace:0;mso-table-rspace:0">
                      <tbody>
                        <tr>
                          <td>
                            <table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace:0;mso-table-rspace:0;border-radius:0;color:#000;width:700px;margin:0 auto" width="700">
                              <tbody>
                                <tr>
                                  <td class="column column-1" width="100%" style="mso-table-lspace:0;mso-table-rspace:0;font-weight:400;text-align:left;padding-bottom:5px;padding-top:5px;vertical-align:top;border-top:0;border-right:0;border-bottom:0;border-left:0">
                                    <div class="spacer_block block-1" style="height:60px;line-height:60px;font-size:1px">&#8202;</div>
                                    <table class="text_block block-2" width="100%" border="0" cellpadding="15" cellspacing="0" role="presentation" style="mso-table-lspace:0;mso-table-rspace:0;word-break:break-word">
                                      <tr>
                                        <td class="pad">
                                          <div style="font-family:sans-serif">
                                            <div class style="font-size:14px;font-family:Arial,Helvetica Neue,Helvetica,sans-serif;mso-line-height-alt:21px;color:#555;line-height:1.5">
                                              <p style="margin:0;font-size:18px;mso-line-height-alt:33px;letter-spacing:normal">
                                                <strong><span style="word-break: break-word; font-size: 22px;">Напоминание:</span></strong>
                                                <span style="word-break: break-word; font-size: 22px;">&nbsp;</span>
                                              </p>
                                              <p style="margin:0;font-size:18px;mso-line-height-alt:27px;letter-spacing:normal">
                                                <span style="word-break: break-word; font-size: 18px;">
                                                  <span style="word-break: break-word;">time / к задаче "title"</span>
                                                </span>
                                              </p>
                                              <p style="margin:0;font-size:18px;mso-line-height-alt:21px;letter-spacing:normal">&nbsp;</p>
                                              <p style="margin:0;font-size:18px;mso-line-height-alt:33px;letter-spacing:normal">
                                                <span style="word-break: break-word; font-size: 22px;">
                                                  <span style="word-break: break-word;">description</span>
                                                </span>
                                              </p>
                                              <p style="margin:0;font-size:18px;mso-line-height-alt:27px;letter-spacing:normal">
                                                <span style="word-break: break-word; font-size: 18px;">
                                                  <span style="word-break: break-word;">Добавил: author</span>
                                                </span>
                                              </p>
                                              <p style="margin:0;font-size:18px;mso-line-height-alt:27px;letter-spacing:normal">
                                                <span style="word-break: break-word; font-size: 18px;">
                                                  <span style="word-break: break-word;">Проект: project</span>
                                                </span>
                                              </p>
                                              <p style="margin:0;font-size:18px;mso-line-height-alt:21px;letter-spacing:normal">&nbsp;</p>
                                              <p style="margin:0;font-size:18px;mso-line-height-alt:27px;letter-spacing:normal">
                                                <em>
                                                  <span style="word-break: break-word; font-size: 18px;">
                                                    <span style="word-break: break-word;">
                                                      <a href="domain/#/crm/task/taskId?activityId={activity.id}" target="_blank" style="text-decoration: underline; color: #0068A5;" rel="noopener">
                                                        <em>
                                                          <span style="word-break: break-word; font-size: 18px;">
                                                            <span style="word-break: break-word;">Ссылка на напоминание</span>
                                                          </span>
                                                        </em>
                                                      </a>
                                                    </span>
                                                  </span>
                                                </em>
                                              </p>
                                            </div>
                                          </div>
                                        </td>
                                      </tr>
                                    </table>
                                    <div class="spacer_block block-3" style="height:100px;line-height:100px;font-size:1px">&#8202;</div>
                                    <table class="text_block block-4" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace:0;mso-table-rspace:0;word-break:break-word">
                                      <tr>
                                        <td class="pad">
                                          <div style="font-family:sans-serif">
                                            <div class style="font-size:14px;font-family:Arial,Helvetica Neue,Helvetica,sans-serif;mso-line-height-alt:16.8px;color:#555;line-height:1.2">
                                              <p style="margin:0;font-size:14px;mso-line-height-alt:16.8px">Служба уведомлений</p>
                                              <p style="margin:0;font-size:14px;mso-line-height-alt:16.8px">сервиса CRM {organization}</p>
                                              <p style="margin:0;font-size:14px;mso-line-height-alt:16.8px">&nbsp;</p>
                                              <p style="margin:0;font-size:14px;mso-line-height-alt:16.8px">
                                                <span style="word-break: break-word; font-size: 11px; color: #777777;">Это письмо - часть процесса доставки комментариев и сообщений сервиса CRM&nbsp;{organization}
                                                </span>
                                              </p>
                                              <p style="margin:0;font-size:14px;mso-line-height-alt:16.8px">
                                                <span style="word-break: break-word; font-size: 11px; color: #777777;">Вы получили это письмо, так как являетесь пользователем сервиса CRM {organization}.
                                                </span>
                                              </p>
                                              <p style="margin:0;mso-line-height-alt:13.2px">
                                                <span style="word-break: break-word; font-size: 11px; color: #777777;">Чтобы контролировать входящие сообщения, <a href="1" target="_blank" style="text-decoration: underline; color: #0068A5;" rel="noopener">измените настройки в своем профиле.</a>
                                                </span>
                                              </p>
                                            </div>
                                          </div>
                                        </td>
                                      </tr>
                                    </table>
                                  </td>
                                </tr>
                              </tbody>
                            </table>
                          </td>
                        </tr>
                      </tbody>
                    </table>
                  </td>
                </tr>  
              </tbody>
            </table>
        """.trimIndent()
}