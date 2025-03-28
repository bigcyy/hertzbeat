/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hertzbeat.alert.service;

import java.util.List;
import java.util.Optional;
import org.apache.hertzbeat.common.entity.alerter.GroupAlert;
import org.apache.hertzbeat.common.entity.alerter.NoticeReceiver;
import org.apache.hertzbeat.common.entity.alerter.NoticeRule;
import org.apache.hertzbeat.common.entity.alerter.NoticeTemplate;
import org.springframework.data.domain.Page;

/**
 * Message notification configuration interface
 */
public interface NoticeConfigService {

    /**
     * Dynamic conditional query
     * @param name Recipient name,support fuzzy query
     * @param pageIndex Page number
     * @param pageSize Number of records per page
     * @return Search result
     */
    Page<NoticeReceiver> getNoticeReceivers(String name, int pageIndex, int pageSize);

    /**
     * Dynamic conditional query
     * @param name Template name,support fuzzy query
     * @param preset Whether it is a system preset template
     *               true: System preset template
     *               false: Custom template
     * @param pageIndex Page number
     * @param pageSize Number of records per page
     * @return Search result
     */
    Page<NoticeTemplate> getNoticeTemplates(String name, boolean preset, int pageIndex, int pageSize);

    /**
     * Dynamic conditional query
     * @param name Recipient name ,support fuzzy query
     * @param pageIndex Page number
     * @param pageSize Number of records per page
     * @return Search result
     */
    Page<NoticeRule> getNoticeRules(String name, int pageIndex, int pageSize);

    /**
     * Add a notification recipient
     * @param noticeReceiver recipient information
     */
    void addReceiver(NoticeReceiver noticeReceiver);

    /**
     * Modify notification recipients
     * @param noticeReceiver recipient information
     */
    void editReceiver(NoticeReceiver noticeReceiver);

    /**
     * Delete recipient information based on recipient ID
     * @param receiverId Recipient ID
     */
    void deleteReceiver(Long receiverId);

    /**
     * Added notification policy
     * @param noticeRule Notification strategy
     */
    void addNoticeRule(NoticeRule noticeRule);

    /**
     * Modify Notification Policy
     * @param noticeRule Notification strategy
     */
    void editNoticeRule(NoticeRule noticeRule);

    /**
     * Delete the specified notification policy
     * @param ruleId Notification Policy ID
     */
    void deleteNoticeRule(Long ruleId);

    /**
     * According to the alarm information matching all notification policies, filter out the recipients who need to be notified
     * @param alert Alarm information
     * @return Receiver
     */
    List<NoticeRule> getReceiverFilterRule(GroupAlert alert);

    /**
     * Query the template information according to the template ID
     * @param id Template ID
     * @return Template   
     */
    NoticeTemplate getOneTemplateById(Long id);

    /**
     * Query recipient information based on recipient ID (primary key Id)
     * @param receiverId Receiver ID (primary key ID)
     * @return Recipient Entity
     */
    NoticeReceiver getReceiverById(Long receiverId);

    /**
     * Query specific notification rules according to the rule ID (primary key ID)
     * @param ruleId Rule ID
     * @return Notification Rule Entity
     */
    NoticeRule getNoticeRulesById(Long ruleId);


    /**
     * Add a notification template
     * @param noticeTemplate template information 
     */
    void addNoticeTemplate(NoticeTemplate noticeTemplate);

    /**
     * Modify notification templates
     * @param noticeTemplate template information 
     */
    void editNoticeTemplate(NoticeTemplate noticeTemplate);

    /**
     * Delete template information based on Template ID
     * @param templateId Template ID
     */
    void deleteNoticeTemplate(Long templateId);

    /**
     * Query specific notification templates according to the template ID (primary key ID)
     * @param templateId Template ID
     * @return Notification Template Entity
     */
    Optional<NoticeTemplate> getNoticeTemplatesById(Long templateId);

    /**
     * Query specific notification templates according to the template type
     * @param type            Template type
     * @return Notification Template Entity
     */
    NoticeTemplate getDefaultNoticeTemplateByType(Byte type);
    
    /**
     * alert Send test message
     * @param noticeReceiver recipient information
     * @return true send success | false send fail
     */
    boolean sendTestMsg(NoticeReceiver noticeReceiver);

    /**
     * Query all notification recipients
     * @return Recipient List
     */
    List<NoticeReceiver> getAllNoticeReceivers();

    /**
     * Query all notification policies
     * @return Notification Policy List
     */
    List<NoticeTemplate> getAllNoticeTemplates();
}
