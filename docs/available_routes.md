# Discourse version v1.6.0.beta-11
# RAILS_ENV=production bundle exec rake routes >> available_routes.txt
                                Prefix Verb     URI Pattern                                                                 Controller#Action
                                  blog          /                                                                           Blog::Engine
                                       GET|POST /404(.:format)                                                              exceptions#not_found
                                       GET      /404-body(.:format)                                                         exceptions#not_found_body
                      webhooks_mailgun POST     /webhooks/mailgun(.:format)                                                 webhooks#mailgun
                     webhooks_sendgrid POST     /webhooks/sendgrid(.:format)                                                webhooks#sendgrid
                      webhooks_mailjet POST     /webhooks/mailjet(.:format)                                                 webhooks#mailjet
                     webhooks_mandrill POST     /webhooks/mandrill(.:format)                                                webhooks#mandrill
                           sidekiq_web          /sidekiq                                                                    Sidekiq::Web
                           logster_web          /logs                                                                       Logster::Web
          live_post_counts_about_index GET      /about/live_post_counts(.:format)                                           about#live_post_counts
                           about_index GET      /about(.:format)                                                            about#index
                                       POST     /about(.:format)                                                            about#create
                             new_about GET      /about/new(.:format)                                                        about#new
                            edit_about GET      /about/:id/edit(.:format)                                                   about#edit
                                 about GET      /about/:id(.:format)                                                        about#show
                                       PATCH    /about/:id(.:format)                                                        about#update
                                       PUT      /about/:id(.:format)                                                        about#update
                                       DELETE   /about/:id(.:format)                                                        about#destroy
                       directory_items GET      /directory_items(.:format)                                                  directory_items#index
                                       POST     /directory_items(.:format)                                                  directory_items#create
                    new_directory_item GET      /directory_items/new(.:format)                                              directory_items#new
                   edit_directory_item GET      /directory_items/:id/edit(.:format)                                         directory_items#edit
                        directory_item GET      /directory_items/:id(.:format)                                              directory_items#show
                                       PATCH    /directory_items/:id(.:format)                                              directory_items#update
                                       PUT      /directory_items/:id(.:format)                                              directory_items#update
                                       DELETE   /directory_items/:id(.:format)                                              directory_items#destroy
                                  site GET      /site(.:format)                                                             site#site
                         site_settings GET      /site/settings(.:format)                                                    site#settings
                      site_custom_html GET      /site/custom_html(.:format)                                                 site#custom_html
                           site_banner GET      /site/banner(.:format)                                                      site#banner
                            site_emoji GET      /site/emoji(.:format)                                                       site#emoji
                                       GET      /site_customizations/:key(.:format)                                         site_customizations#show
                                forums GET      /forums(.:format)                                                           forums#index
                                       POST     /forums(.:format)                                                           forums#create
                             new_forum GET      /forums/new(.:format)                                                       forums#new
                            edit_forum GET      /forums/:id/edit(.:format)                                                  forums#edit
                                 forum GET      /forums/:id(.:format)                                                       forums#show
                                       PATCH    /forums/:id(.:format)                                                       forums#update
                                       PUT      /forums/:id(.:format)                                                       forums#update
                                       DELETE   /forums/:id(.:format)                                                       forums#destroy
                            srv_status GET      /srv/status(.:format)                                                       forums#status
                                 admin GET      /admin(.:format)                                                            admin/admin#index
                         admin_plugins GET      /admin/plugins(.:format)                                                    admin/plugins#index
                                       GET      /admin/site_settings/category/:id(.:format)                                 admin/site_settings#index
                   admin_site_settings GET      /admin/site_settings(.:format)                                              admin/site_settings#index
                                       POST     /admin/site_settings(.:format)                                              admin/site_settings#create
                new_admin_site_setting GET      /admin/site_settings/new(.:format)                                          admin/site_settings#new
               edit_admin_site_setting GET      /admin/site_settings/:id/edit(.:format)                                     admin/site_settings#edit
                    admin_site_setting GET      /admin/site_settings/:id(.:format)                                          admin/site_settings#show
                                       PATCH    /admin/site_settings/:id(.:format)                                          admin/site_settings#update
                                       PUT      /admin/site_settings/:id(.:format)                                          admin/site_settings#update
                                       DELETE   /admin/site_settings/:id(.:format)                                          admin/site_settings#destroy
                                       GET      /admin/reports/:type(.:format)                                              admin/reports#show
 refresh_automatic_groups_admin_groups POST     /admin/groups/refresh_automatic_groups(.:format)                            admin/groups#refresh_automatic_groups
                     bulk_admin_groups GET      /admin/groups/bulk(.:format)                                                admin/groups#bulk
            bulk_complete_admin_groups GET      /admin/groups/bulk-complete(.:format)                                       admin/groups#bulk
                                       PUT      /admin/groups/bulk(.:format)                                                admin/groups#bulk_perform
                    owners_admin_group PUT      /admin/groups/:id/owners(.:format)                                          admin/groups#add_owners
                                       DELETE   /admin/groups/:id/owners(.:format)                                          admin/groups#remove_owner
                          admin_groups GET      /admin/groups(.:format)                                                     admin/groups#index
                                       POST     /admin/groups(.:format)                                                     admin/groups#create
                       new_admin_group GET      /admin/groups/new(.:format)                                                 admin/groups#new
                      edit_admin_group GET      /admin/groups/:id/edit(.:format)                                            admin/groups#edit
                           admin_group GET      /admin/groups/:id(.:format)                                                 admin/groups#show
                                       PATCH    /admin/groups/:id(.:format)                                                 admin/groups#update
                                       PUT      /admin/groups/:id(.:format)                                                 admin/groups#update
                                       DELETE   /admin/groups/:id(.:format)                                                 admin/groups#destroy
                                       GET      /admin/groups/:type(.:format)                                               admin/groups#show
                                       GET      /admin/groups/:type/:id(.:format)                                           admin/groups#show
                                       GET      /admin/users/list/:query(.:format)                                          admin/users#index
                   ip_info_admin_users GET      /admin/users/ip-info(.:format)                                              admin/users#ip_info
delete_others_with_same_ip_admin_users DELETE   /admin/users/delete-others-with-same-ip(.:format)                           admin/users#delete_other_accounts_with_same_ip
 total_others_with_same_ip_admin_users GET      /admin/users/total-others-with-same-ip(.:format)                            admin/users#total_other_accounts_with_same_ip
              approve_bulk_admin_users PUT      /admin/users/approve-bulk(.:format)                                         admin/users#approve_bulk
               reject_bulk_admin_users DELETE   /admin/users/reject-bulk(.:format)                                          admin/users#reject_bulk
                    admin_user_suspend PUT      /admin/users/:user_id/suspend(.:format)                                     admin/users#suspend {:user_id=>/[\w.\-]+/}
           admin_user_delete_all_posts PUT      /admin/users/:user_id/delete_all_posts(.:format)                            admin/users#delete_all_posts {:user_id=>/[\w.\-]+/}
                  admin_user_unsuspend PUT      /admin/users/:user_id/unsuspend(.:format)                                   admin/users#unsuspend {:user_id=>/[\w.\-]+/}
               admin_user_revoke_admin PUT      /admin/users/:user_id/revoke_admin(.:format)                                admin/users#revoke_admin {:user_id=>/[\w.\-]+/}
                admin_user_grant_admin PUT      /admin/users/:user_id/grant_admin(.:format)                                 admin/users#grant_admin {:user_id=>/[\w.\-]+/}
           admin_user_generate_api_key POST     /admin/users/:user_id/generate_api_key(.:format)                            admin/users#generate_api_key {:user_id=>/[\w.\-]+/}
             admin_user_revoke_api_key DELETE   /admin/users/:user_id/revoke_api_key(.:format)                              admin/users#revoke_api_key {:user_id=>/[\w.\-]+/}
          admin_user_revoke_moderation PUT      /admin/users/:user_id/revoke_moderation(.:format)                           admin/users#revoke_moderation {:user_id=>/[\w.\-]+/}
           admin_user_grant_moderation PUT      /admin/users/:user_id/grant_moderation(.:format)                            admin/users#grant_moderation {:user_id=>/[\w.\-]+/}
                    admin_user_approve PUT      /admin/users/:user_id/approve(.:format)                                     admin/users#approve {:user_id=>/[\w.\-]+/}
           admin_user_refresh_browsers POST     /admin/users/:user_id/refresh_browsers(.:format)                            admin/users#refresh_browsers {:user_id=>/[\w.\-]+/}
                    admin_user_log_out POST     /admin/users/:user_id/log_out(.:format)                                     admin/users#log_out {:user_id=>/[\w.\-]+/}
                   admin_user_activate PUT      /admin/users/:user_id/activate(.:format)                                    admin/users#activate {:user_id=>/[\w.\-]+/}
                 admin_user_deactivate PUT      /admin/users/:user_id/deactivate(.:format)                                  admin/users#deactivate {:user_id=>/[\w.\-]+/}
                      admin_user_block PUT      /admin/users/:user_id/block(.:format)                                       admin/users#block {:user_id=>/[\w.\-]+/}
                    admin_user_unblock PUT      /admin/users/:user_id/unblock(.:format)                                     admin/users#unblock {:user_id=>/[\w.\-]+/}
                admin_user_trust_level PUT      /admin/users/:user_id/trust_level(.:format)                                 admin/users#trust_level {:user_id=>/[\w.\-]+/}
           admin_user_trust_level_lock PUT      /admin/users/:user_id/trust_level_lock(.:format)                            admin/users#trust_level_lock {:user_id=>/[\w.\-]+/}
              admin_user_primary_group PUT      /admin/users/:user_id/primary_group(.:format)                               admin/users#primary_group {:user_id=>/[\w.\-]+/}
                     admin_user_groups POST     /admin/users/:user_id/groups(.:format)                                      admin/users#add_group {:user_id=>/[\w.\-]+/}
                                       DELETE   /admin/users/:user_id/groups/:group_id(.:format)                            admin/users#remove_group {:user_id=>/[\w.\-]+/}
                     admin_user_badges GET      /admin/users/:user_id/badges(.:format)                                      admin/users#badges {:user_id=>/[\w.\-]+/}
        admin_user_leader_requirements GET      /admin/users/:user_id/leader_requirements(.:format)                         admin/users#tl3_requirements {:user_id=>/[\w.\-]+/}
           admin_user_tl3_requirements GET      /admin/users/:user_id/tl3_requirements(.:format)                            admin/users#tl3_requirements {:user_id=>/[\w.\-]+/}
                  admin_user_anonymize PUT      /admin/users/:user_id/anonymize(.:format)                                   admin/users#anonymize {:user_id=>/[\w.\-]+/}
         admin_user_reset_bounce_score POST     /admin/users/:user_id/reset_bounce_score(.:format)                          admin/users#reset_bounce_score {:user_id=>/[\w.\-]+/}
                           admin_users GET      /admin/users(.:format)                                                      admin/users#index
                                       POST     /admin/users(.:format)                                                      admin/users#create
                        new_admin_user GET      /admin/users/new(.:format)                                                  admin/users#new
                       edit_admin_user GET      /admin/users/:id/edit(.:format)                                             admin/users#edit {:id=>/[\w.\-]+/}
                            admin_user PATCH    /admin/users/:id(.:format)                                                  admin/users#update {:id=>/[\w.\-]+/}
                                       PUT      /admin/users/:id(.:format)                                                  admin/users#update {:id=>/[\w.\-]+/}
                                       DELETE   /admin/users/:id(.:format)                                                  admin/users#destroy {:id=>/[\w.\-]+/}
                                       GET      /admin/users/:id.json(.:format)                                             admin/users#show {:format=>"json"}
                                       GET      /admin/users/:id/:username(.:format)                                        admin/users#show {:username=>/[\w.\-]+/}
                                       GET      /admin/users/:id/:username/badges(.:format)                                 admin/users#show
                  admin_users_sync_sso POST     /admin/users/sync_sso(.:format)                                             admin/users#sync_sso
              admin_users_invite_admin POST     /admin/users/invite_admin(.:format)                                         admin/users#invite_admin
               admin_impersonate_index GET      /admin/impersonate(.:format)                                                admin/impersonate#index
                                       POST     /admin/impersonate(.:format)                                                admin/impersonate#create
                 new_admin_impersonate GET      /admin/impersonate/new(.:format)                                            admin/impersonate#new
                edit_admin_impersonate GET      /admin/impersonate/:id/edit(.:format)                                       admin/impersonate#edit
                     admin_impersonate GET      /admin/impersonate/:id(.:format)                                            admin/impersonate#show
                                       PATCH    /admin/impersonate/:id(.:format)                                            admin/impersonate#update
                                       PUT      /admin/impersonate/:id(.:format)                                            admin/impersonate#update
                                       DELETE   /admin/impersonate/:id(.:format)                                            admin/impersonate#destroy
                test_admin_email_index POST     /admin/email/test(.:format)                                                 admin/email#test
                sent_admin_email_index GET      /admin/email/sent(.:format)                                                 admin/email#sent
             skipped_admin_email_index GET      /admin/email/skipped(.:format)                                              admin/email#skipped
             bounced_admin_email_index GET      /admin/email/bounced(.:format)                                              admin/email#bounced
            received_admin_email_index GET      /admin/email/received(.:format)                                             admin/email#received
            rejected_admin_email_index GET      /admin/email/rejected(.:format)                                             admin/email#rejected
                                       GET      /admin/email/incoming/:id/raw(.:format)                                     admin/email#raw_email
                                       GET      /admin/email/incoming/:id(.:format)                                         admin/email#incoming
      preview_digest_admin_email_index GET      /admin/email/preview-digest(.:format)                                       admin/email#preview_digest
         handle_mail_admin_email_index POST     /admin/email/handle_mail(.:format)                                          admin/email#handle_mail
                     admin_email_index GET      /admin/email(.:format)                                                      admin/email#index
                                       POST     /admin/email(.:format)                                                      admin/email#create
                       new_admin_email GET      /admin/email/new(.:format)                                                  admin/email#new
                      edit_admin_email GET      /admin/email/:id/edit(.:format)                                             admin/email#edit
                           admin_email GET      /admin/email/:id(.:format)                                                  admin/email#show
                                       PATCH    /admin/email/:id(.:format)                                                  admin/email#update
                                       PUT      /admin/email/:id(.:format)                                                  admin/email#update
                                       DELETE   /admin/email/:id(.:format)                                                  admin/email#destroy
               admin_staff_action_logs GET      /admin/logs/staff_action_logs(.:format)                                     admin/staff_action_logs#index
                 admin_screened_emails GET      /admin/logs/screened_emails(.:format)                                       admin/screened_emails#index
                  admin_screened_email DELETE   /admin/logs/screened_emails/:id(.:format)                                   admin/screened_emails#destroy
   roll_up_admin_screened_ip_addresses POST     /admin/logs/screened_ip_addresses/roll_up(.:format)                         admin/screened_ip_addresses#roll_up
           admin_screened_ip_addresses GET      /admin/logs/screened_ip_addresses(.:format)                                 admin/screened_ip_addresses#index
                                       POST     /admin/logs/screened_ip_addresses(.:format)                                 admin/screened_ip_addresses#create
             admin_screened_ip_address PATCH    /admin/logs/screened_ip_addresses/:id(.:format)                             admin/screened_ip_addresses#update
                                       PUT      /admin/logs/screened_ip_addresses/:id(.:format)                             admin/screened_ip_addresses#update
                                       DELETE   /admin/logs/screened_ip_addresses/:id(.:format)                             admin/screened_ip_addresses#destroy
                   admin_screened_urls GET      /admin/logs/screened_urls(.:format)                                         admin/screened_urls#index
                            admin_logs GET      /admin/logs(.:format)                                                       admin/staff_action_logs#index
                       admin_customize GET      /admin/customize(.:format)                                                  admin/color_schemes#index
              admin_customize_css_html GET      /admin/customize/css_html(.:format)                                         admin/site_customizations#index
                                       GET      /admin/customize/css_html/:id/:section(.:format)                            admin/site_customizations#index
                admin_customize_colors GET      /admin/customize/colors(.:format)                                           admin/color_schemes#index
            admin_customize_permalinks GET      /admin/customize/permalinks(.:format)                                       admin/permalinks#index
             admin_customize_embedding GET      /admin/customize/embedding(.:format)                                        admin/embedding#show
                                       PUT      /admin/customize/embedding(.:format)                                        admin/embedding#update
                           admin_flags GET      /admin/flags(.:format)                                                      admin/flags#index
                                       GET      /admin/flags/:filter(.:format)                                              admin/flags#index
                                       POST     /admin/flags/agree/:id(.:format)                                            admin/flags#agree
                                       POST     /admin/flags/disagree/:id(.:format)                                         admin/flags#disagree
                                       POST     /admin/flags/defer/:id(.:format)                                            admin/flags#defer
             admin_site_customizations GET      /admin/site_customizations(.:format)                                        admin/site_customizations#index
                                       POST     /admin/site_customizations(.:format)                                        admin/site_customizations#create
          new_admin_site_customization GET      /admin/site_customizations/new(.:format)                                    admin/site_customizations#new
         edit_admin_site_customization GET      /admin/site_customizations/:id/edit(.:format)                               admin/site_customizations#edit
              admin_site_customization GET      /admin/site_customizations/:id(.:format)                                    admin/site_customizations#show
                                       PATCH    /admin/site_customizations/:id(.:format)                                    admin/site_customizations#update
                                       PUT      /admin/site_customizations/:id(.:format)                                    admin/site_customizations#update
                                       DELETE   /admin/site_customizations/:id(.:format)                                    admin/site_customizations#destroy
                     admin_user_fields GET      /admin/customize/user_fields(.:format)                                      admin/user_fields#index
                                       POST     /admin/customize/user_fields(.:format)                                      admin/user_fields#create
                  new_admin_user_field GET      /admin/customize/user_fields/new(.:format)                                  admin/user_fields#new
                 edit_admin_user_field GET      /admin/customize/user_fields/:id/edit(.:format)                             admin/user_fields#edit
                      admin_user_field GET      /admin/customize/user_fields/:id(.:format)                                  admin/user_fields#show
                                       PATCH    /admin/customize/user_fields/:id(.:format)                                  admin/user_fields#update
                                       PUT      /admin/customize/user_fields/:id(.:format)                                  admin/user_fields#update
                                       DELETE   /admin/customize/user_fields/:id(.:format)                                  admin/user_fields#destroy
                          admin_emojis GET      /admin/customize/emojis(.:format)                                           admin/emojis#index
                                       POST     /admin/customize/emojis(.:format)                                           admin/emojis#create
                       new_admin_emoji GET      /admin/customize/emojis/new(.:format)                                       admin/emojis#new
                      edit_admin_emoji GET      /admin/customize/emojis/:id/edit(.:format)                                  admin/emojis#edit
                           admin_emoji GET      /admin/customize/emojis/:id(.:format)                                       admin/emojis#show
                                       PATCH    /admin/customize/emojis/:id(.:format)                                       admin/emojis#update
                                       PUT      /admin/customize/emojis/:id(.:format)                                       admin/emojis#update
                                       DELETE   /admin/customize/emojis/:id(.:format)                                       admin/emojis#destroy
                      admin_site_texts GET      /admin/customize/site_texts(.:format)                                       admin/site_texts#index
                                       GET      /admin/customize/site_texts(/:id)(.:format)                                 admin/site_texts#show {:id=>/[\w.\-]+/i}
                                       PUT      /admin/customize/site_texts(/:id)(.:format)                                 admin/site_texts#update {:id=>/[\w.\-]+/i}
                                       DELETE   /admin/customize/site_texts(/:id)(.:format)                                 admin/site_texts#revert {:id=>/[\w.\-]+/i}
                 admin_email_templates GET      /admin/customize/email_templates(.:format)                                  admin/email_templates#index
                                       GET      /admin/customize/email_templates(/:id)(.:format)                            admin/email_templates#show {:id=>/[0-9a-z_.]+/}
                                       PUT      /admin/customize/email_templates(/:id)(.:format)                            admin/email_templates#update {:id=>/[0-9a-z_.]+/}
                                       DELETE   /admin/customize/email_templates(/:id)(.:format)                            admin/email_templates#revert {:id=>/[0-9a-z_.]+/}
                admin_embeddable_hosts GET      /admin/embeddable_hosts(.:format)                                           admin/embeddable_hosts#index
                                       POST     /admin/embeddable_hosts(.:format)                                           admin/embeddable_hosts#create
             new_admin_embeddable_host GET      /admin/embeddable_hosts/new(.:format)                                       admin/embeddable_hosts#new
            edit_admin_embeddable_host GET      /admin/embeddable_hosts/:id/edit(.:format)                                  admin/embeddable_hosts#edit
                 admin_embeddable_host GET      /admin/embeddable_hosts/:id(.:format)                                       admin/embeddable_hosts#show
                                       PATCH    /admin/embeddable_hosts/:id(.:format)                                       admin/embeddable_hosts#update
                                       PUT      /admin/embeddable_hosts/:id(.:format)                                       admin/embeddable_hosts#update
                                       DELETE   /admin/embeddable_hosts/:id(.:format)                                       admin/embeddable_hosts#destroy
                   admin_color_schemes GET      /admin/color_schemes(.:format)                                              admin/color_schemes#index
                                       POST     /admin/color_schemes(.:format)                                              admin/color_schemes#create
                new_admin_color_scheme GET      /admin/color_schemes/new(.:format)                                          admin/color_schemes#new
               edit_admin_color_scheme GET      /admin/color_schemes/:id/edit(.:format)                                     admin/color_schemes#edit
                    admin_color_scheme GET      /admin/color_schemes/:id(.:format)                                          admin/color_schemes#show
                                       PATCH    /admin/color_schemes/:id(.:format)                                          admin/color_schemes#update
                                       PUT      /admin/color_schemes/:id(.:format)                                          admin/color_schemes#update
                                       DELETE   /admin/color_schemes/:id(.:format)                                          admin/color_schemes#destroy
                      admin_permalinks GET      /admin/permalinks(.:format)                                                 admin/permalinks#index
                                       POST     /admin/permalinks(.:format)                                                 admin/permalinks#create
                   new_admin_permalink GET      /admin/permalinks/new(.:format)                                             admin/permalinks#new
                  edit_admin_permalink GET      /admin/permalinks/:id/edit(.:format)                                        admin/permalinks#edit
                       admin_permalink GET      /admin/permalinks/:id(.:format)                                             admin/permalinks#show
                                       PATCH    /admin/permalinks/:id(.:format)                                             admin/permalinks#update
                                       PUT      /admin/permalinks/:id(.:format)                                             admin/permalinks#update
                                       DELETE   /admin/permalinks/:id(.:format)                                             admin/permalinks#destroy
                   admin_version_check GET      /admin/version_check(.:format)                                              admin/versions#show
        problems_admin_dashboard_index GET      /admin/dashboard/problems(.:format)                                         admin/dashboard#problems
                 admin_dashboard_index GET      /admin/dashboard(.:format)                                                  admin/dashboard#index
                   key_admin_api_index POST     /admin/api/key(.:format)                                                    admin/api#create_master_key
                                       PUT      /admin/api/key(.:format)                                                    admin/api#regenerate_key
                                       DELETE   /admin/api/key(.:format)                                                    admin/api#revoke_key
                       admin_api_index GET      /admin/api(.:format)                                                        admin/api#index
                                       GET      /admin/backups/:id(.:format)                                                admin/backups#show {:id=>/.+\.(tar\.gz|tgz)/i}
                                       DELETE   /admin/backups/:id(.:format)                                                admin/backups#destroy {:id=>/.+\.(tar\.gz|tgz)/i}
                  restore_admin_backup POST     /admin/backups/:id/restore(.:format)                                        admin/backups#restore {:id=>/.+\.(tar\.gz|tgz)/i}
                    logs_admin_backups GET      /admin/backups/logs(.:format)                                               admin/backups#logs
                  status_admin_backups GET      /admin/backups/status(.:format)                                             admin/backups#status
                  cancel_admin_backups GET      /admin/backups/cancel(.:format)                                             admin/backups#cancel
                rollback_admin_backups GET      /admin/backups/rollback(.:format)                                           admin/backups#rollback
                readonly_admin_backups PUT      /admin/backups/readonly(.:format)                                           admin/backups#readonly
                  upload_admin_backups GET      /admin/backups/upload(.:format)                                             admin/backups#check_backup_chunk
                                       POST     /admin/backups/upload(.:format)                                             admin/backups#upload_backup_chunk
                         admin_backups GET      /admin/backups(.:format)                                                    admin/backups#index
                                       POST     /admin/backups(.:format)                                                    admin/backups#create
                    types_admin_badges GET      /admin/badges/types(.:format)                                               admin/badges#badge_types
          badge_groupings_admin_badges POST     /admin/badges/badge_groupings(.:format)                                     admin/badges#save_badge_groupings
                  preview_admin_badges POST     /admin/badges/preview(.:format)                                             admin/badges#preview
                          admin_badges GET      /admin/badges(.:format)                                                     admin/badges#index
                                       POST     /admin/badges(.:format)                                                     admin/badges#create
                       new_admin_badge GET      /admin/badges/new(.:format)                                                 admin/badges#new
                      edit_admin_badge GET      /admin/badges/:id/edit(.:format)                                            admin/badges#edit
                           admin_badge GET      /admin/badges/:id(.:format)                                                 admin/badges#show
                                       PATCH    /admin/badges/:id(.:format)                                                 admin/badges#update
                                       PUT      /admin/badges/:id(.:format)                                                 admin/badges#update
                                       DELETE   /admin/badges/:id(.:format)                                                 admin/badges#destroy
                    admin_memory_stats GET      /admin/memory_stats(.:format)                                               admin/diagnostics#memory_stats
                       admin_dump_heap GET      /admin/dump_heap(.:format)                                                  admin/diagnostics#dump_heap
            admin_dump_statement_cache GET      /admin/dump_statement_cache(.:format)                                       admin/diagnostics#dump_statement_cache
            email_preferences_redirect GET      /email_preferences(.:format)                                                email#preferences_redirect
                     email_unsubscribe GET      /email/unsubscribe/:key(.:format)                                           email#unsubscribe
                    email_unsubscribed GET      /email/unsubscribed(.:format)                                               email#unsubscribed
             email_perform_unsubscribe POST     /email/unsubscribe/:key(.:format)                                           email#perform_unsubscribe
                        session_become GET      /session/:session_id/become(.:format)                                       session#become {:session_id=>/[\w.\-]+/}
         forgot_password_session_index POST     /session/forgot_password(.:format)                                          session#forgot_password
                         session_index POST     /session(.:format)                                                          session#create
                               session DELETE   /session/:id(.:format)                                                      session#destroy {:id=>/[\w.\-]+/}
                           session_sso GET      /session/sso(.:format)                                                      session#sso
                     session_sso_login GET      /session/sso_login(.:format)                                                session#sso_login
                  session_sso_provider GET      /session/sso_provider(.:format)                                             session#sso_provider
                       session_current GET      /session/current(.:format)                                                  session#current
                          session_csrf GET      /session/csrf(.:format)                                                     session#csrf
                     composer_messages GET      /composer_messages(.:format)                                                composer_messages#index
                  check_username_users GET      /users/check_username(.:format)                                             users#check_username
               is_local_username_users GET      /users/is_local_username(.:format)                                          users#is_local_username
                                 users GET      /users(.:format)                                                            users#index
                                       POST     /users(.:format)                                                            users#create
                              new_user GET      /users/new(.:format)                                                        users#new
                             edit_user GET      /users/:id/edit(.:format)                                                   users#edit
                          static_index GET      /static(.:format)                                                           static#index
                                       POST     /static(.:format)                                                           static#create
                            new_static GET      /static/new(.:format)                                                       static#new
                           edit_static GET      /static/:id/edit(.:format)                                                  static#edit
                                static GET      /static/:id(.:format)                                                       static#show
                                       PATCH    /static/:id(.:format)                                                       static#update
                                       PUT      /static/:id(.:format)                                                       static#update
                                       DELETE   /static/:id(.:format)                                                       static#destroy
                                 login POST     /login(.:format)                                                            static#enter {:format=>/(json|html)/}
                                       GET      /login(.:format)                                                            static#show {:id=>"login", :format=>/(json|html)/}
                        password_reset GET      /password-reset(.:format)                                                   static#show {:id=>"password_reset", :format=>/(json|html)/}
                                   faq GET      /faq(.:format)                                                              static#show {:id=>"faq", :format=>/(json|html)/}
                            guidelines GET      /guidelines(.:format)                                                       static#show {:id=>"guidelines", :format=>/(json|html)/}
                                   tos GET      /tos(.:format)                                                              static#show {:id=>"tos", :format=>/(json|html)/}
                               privacy GET      /privacy(.:format)                                                          static#show {:id=>"privacy", :format=>/(json|html)/}
                                signup GET      /signup(.:format)                                                           static#show {:id=>"signup", :format=>/(json|html)/}
                     login_preferences GET      /login-preferences(.:format)                                                static#show {:id=>"login", :format=>/(json|html)/}
                     users_admin_login GET      /users/admin-login(.:format)                                                users#admin_login
                                       PUT      /users/admin-login(.:format)                                                users#admin_login
                                       GET      /users/admin-login/:token(.:format)                                         users#admin_login
                     users_toggle_anon POST     /users/toggle-anon(.:format)                                                users#toggle_anon
                        users_read_faq POST     /users/read-faq(.:format)                                                   users#read_faq
                    users_search_users GET      /users/search/users(.:format)                                               users#search_users
                 users_account_created GET      /users/account-created(.:format)                                            users#account_created
                                       GET      /users/password-reset/:token(.:format)                                      users#password_reset
                                       GET      /users/confirm-email-token/:token(.:format)                                 users#confirm_email_token {:format=>"json"}
                                       PUT      /users/password-reset/:token(.:format)                                      users#password_reset
                                       GET      /users/activate-account/:token(.:format)                                    users#activate_account
              perform_activate_account PUT      /users/activate-account/:token(.:format)                                    users#perform_account_activation
                                       GET      /users/authorize-email/:token(.:format)                                     users_email#confirm
                              users_hp GET      /users/hp(.:format)                                                         users#get_honeypot_value
                                       GET      /my/*path(.:format)                                                         users#my_redirect
                      user_preferences GET      /user_preferences(.:format)                                                 users#user_preferences_redirect
                                       GET      /users/:username/private-messages(.:format)                                 user_actions#private_messages {:username=>/[\w.\-]+/}
                                       GET      /users/:username/private-messages/:filter(.:format)                         user_actions#private_messages {:username=>/[\w.\-]+/}
                                       GET      /users/:username/messages(.:format)                                         user_actions#private_messages {:username=>/[\w.\-]+/}
                                       GET      /users/:username/messages/:filter(.:format)                                 user_actions#private_messages {:username=>/[\w.\-]+/}
                                       GET      /users/:username/messages/group/:group_name(.:format)                       user_actions#private_messages {:username=>/[\w.\-]+/, :group_name=>/[\w.\-]+/}
                                       GET      /users/:username/messages/group/:group_name/archive(.:format)               user_actions#private_messages {:username=>/[\w.\-]+/, :group_name=>/[\w.\-]+/}
                                       GET      /users/:username.json(.:format)                                             users#show {:format=>:json, :username=>/[\w.\-]+/}
                                  user GET      /users/:username(.:format)                                                  users#show {:username=>/[\w.\-]+/}
                                       PUT      /users/:username(.:format)                                                  users#update {:username=>/[\w.\-]+/}
                                       PUT      /users/:username/emails(.:format)                                           users#check_emails {:username=>/[\w.\-]+/}
                     email_preferences GET      /users/:username/preferences(.:format)                                      users#preferences {:username=>/[\w.\-]+/}
                                       GET      /users/:username/preferences/email(.:format)                                users_email#index {:username=>/[\w.\-]+/}
                                       PUT      /users/:username/preferences/email(.:format)                                users_email#update {:username=>/[\w.\-]+/}
                                       GET      /users/:username/preferences/about-me(.:format)                             users#preferences {:username=>/[\w.\-]+/}
                                       GET      /users/:username/preferences/badge_title(.:format)                          users#preferences {:username=>/[\w.\-]+/}
                                       PUT      /users/:username/preferences/badge_title(.:format)                          users#badge_title {:username=>/[\w.\-]+/}
                                       GET      /users/:username/preferences/username(.:format)                             users#preferences {:username=>/[\w.\-]+/}
                                       PUT      /users/:username/preferences/username(.:format)                             users#username {:username=>/[\w.\-]+/}
                                       DELETE   /users/:username/preferences/user_image(.:format)                           users#destroy_user_image {:username=>/[\w.\-]+/}
                                       PUT      /users/:username/preferences/avatar/pick(.:format)                          users#pick_avatar {:username=>/[\w.\-]+/}
                                       GET      /users/:username/preferences/card-badge(.:format)                           users#card_badge {:username=>/[\w.\-]+/}
                                       PUT      /users/:username/preferences/card-badge(.:format)                           users#update_card_badge {:username=>/[\w.\-]+/}
                                       GET      /users/:username/staff-info(.:format)                                       users#staff_info {:username=>/[\w.\-]+/}
                                       GET      /users/:username/summary(.:format)                                          users#summary {:username=>/[\w.\-]+/}
                                       GET      /users/:username/invited(.:format)                                          users#invited {:username=>/[\w.\-]+/}
                                       GET      /users/:username/invited_count(.:format)                                    users#invited_count {:username=>/[\w.\-]+/}
                                       GET      /users/:username/invited/:filter(.:format)                                  users#invited {:username=>/[\w.\-]+/}
    users_action_send_activation_email POST     /users/action/send_activation_email(.:format)                               users#send_activation_email
                                       GET      /users/:username/summary(.:format)                                          users#show {:username=>/[\w.\-]+/}
                                       GET      /users/:username/activity/topics.rss(.:format)                              list#user_topics_feed {:username=>/[\w.\-]+/}
                                       GET      /users/:username/activity.rss(.:format)                                     posts#user_posts_feed {:username=>/[\w.\-]+/}
                                       GET      /users/:username/activity(.:format)                                         users#show {:username=>/[\w.\-]+/}
                                       GET      /users/:username/activity/:filter(.:format)                                 users#show {:username=>/[\w.\-]+/}
                                       GET      /users/:username/badges(.:format)                                           users#show {:username=>/[\w.\-]+/}
                                       GET      /users/:username/notifications(.:format)                                    users#show {:username=>/[\w.\-]+/}
                                       GET      /users/:username/notifications/:filter(.:format)                            users#show {:username=>/[\w.\-]+/}
                                       GET      /users/:username/activity/pending(.:format)                                 users#show {:username=>/[\w.\-]+/}
                                       DELETE   /users/:username(.:format)                                                  users#destroy {:username=>/[\w.\-]+/}
                                       GET      /users/by-external/:external_id(.:format)                                   users#show {:external_id=>/[^\/]+/}
                                       GET      /users/:username/flagged-posts(.:format)                                    users#show {:username=>/[\w.\-]+/}
                                       GET      /users/:username/deleted-posts(.:format)                                    users#show {:username=>/[\w.\-]+/}
                                       GET      /user-badges/:username.json(.:format)                                       user_badges#username {:format=>:json, :username=>/[\w.\-]+/}
                                       GET      /user-badges/:username(.:format)                                            user_badges#username {:username=>/[\w.\-]+/}
                                       POST     /user_avatar/:username/refresh_gravatar(.:format)                           user_avatars#refresh_gravatar {:username=>/[\w.\-]+/}
                                       GET      /letter_avatar/:username/:size/:version.png                                 user_avatars#show_letter {:size=>/\d+/, :username=>/[\w.\-]+/}
                                       GET      /user_avatar/:hostname/:username/:size/:version.png                         user_avatars#show {:hostname=>/[\w\.-]+/, :size=>/\d+/, :username=>/[\w.\-]+/}
                                       GET      /letter_avatar_proxy/:version/letter/:letter/:color/:size.png(.:format)     user_avatars#show_proxy_letter
                                       GET      /highlight-js/:hostname/:version.js                                         highlight_js#show {:hostname=>/[\w\.-]+/}
                                       GET      /stylesheets/:name.css(.:format)                                            stylesheets#show {:name=>/[a-z0-9_]+/}
                               uploads POST     /uploads(.:format)                                                          uploads#create
                                       GET      /uploads/:site/:sha(.:format)                                               uploads#show {:site=>/\w+/, :sha=>/[a-f0-9]{40}/}
                                       GET      /uploads/:site/original/:tree:sha(.:format)                                 uploads#show {:site=>/\w+/, :tree=>/(\w+\/)+/i, :sha=>/[a-f0-9]{40}/}
                                       GET      /uploads/:site/:id/:sha(.:format)                                           uploads#show {:site=>/\w+/, :id=>/\d+/, :sha=>/[a-f0-9]{16}/}
                                 posts GET      /posts(.:format)                                                            posts#latest {:id=>"latest_posts"}
                         private_posts GET      /private-posts(.:format)                                                    posts#latest {:id=>"private_posts"}
                                       GET      /posts/by_number/:topic_id/:post_number(.:format)                           posts#by_number
                                       GET      /posts/:id/reply-history(.:format)                                          posts#reply_history
                                       GET      /posts/:username/deleted(.:format)                                          posts#deleted_posts {:username=>/[\w.\-]+/}
                                       GET      /posts/:username/flagged(.:format)                                          posts#flagged_posts {:username=>/[\w.\-]+/}
                                       GET      /groups/:group_id/posts.rss(.:format)                                       groups#posts_feed
                                       GET      /groups/:group_id/mentions.rss(.:format)                                    groups#mentions_feed
                         group_members GET      /groups/:group_id/members(.:format)                                         groups#members
                           group_posts GET      /groups/:group_id/posts(.:format)                                           groups#posts
                          group_topics GET      /groups/:group_id/topics(.:format)                                          groups#topics
                        group_mentions GET      /groups/:group_id/mentions(.:format)                                        groups#mentions
                        group_messages GET      /groups/:group_id/messages(.:format)                                        groups#messages
                          group_counts GET      /groups/:group_id/counts(.:format)                                          groups#counts
                         members_group PUT      /groups/:id/members(.:format)                                               groups#add_members
                                       DELETE   /groups/:id/members(.:format)                                               groups#remove_member
                   notifications_group POST     /groups/:id/notifications(.:format)                                         groups#set_notifications
                                groups GET      /groups(.:format)                                                           groups#index
                                       POST     /groups(.:format)                                                           groups#create
                             new_group GET      /groups/new(.:format)                                                       groups#new
                            edit_group GET      /groups/:id/edit(.:format)                                                  groups#edit
                                 group GET      /groups/:id(.:format)                                                       groups#show
                                       PATCH    /groups/:id(.:format)                                                       groups#update
                                       PUT      /groups/:id(.:format)                                                       groups#update
                                       DELETE   /groups/:id(.:format)                                                       groups#destroy
                                       DELETE   /admin/groups/:id/members(.:format)                                         groups#remove_member
                                       PUT      /admin/groups/:id/members(.:format)                                         groups#add_members
                                       GET      /group/:id(.:format)                                                        redirect(301, /groups/%{id})
                                       GET      /group/:id/members(.:format)                                                redirect(301, /groups/%{id}/members)
                         post_bookmark PUT      /posts/:post_id/bookmark(.:format)                                          posts#bookmark
                             post_wiki PUT      /posts/:post_id/wiki(.:format)                                              posts#wiki
                        post_post_type PUT      /posts/:post_id/post_type(.:format)                                         posts#post_type
                           post_rebake PUT      /posts/:post_id/rebake(.:format)                                            posts#rebake
                           post_unhide PUT      /posts/:post_id/unhide(.:format)                                            posts#unhide
                          post_replies GET      /posts/:post_id/replies(.:format)                                           posts#replies
                 post_revisions_latest GET      /posts/:post_id/revisions/latest(.:format)                                  posts#latest_revision
                                       GET      /posts/:post_id/revisions/:revision(.:format)                               posts#revisions {:revision=>/\d+/}
                                       PUT      /posts/:post_id/revisions/:revision/hide(.:format)                          posts#hide_revision {:revision=>/\d+/}
                                       PUT      /posts/:post_id/revisions/:revision/show(.:format)                          posts#show_revision {:revision=>/\d+/}
                                       PUT      /posts/:post_id/revisions/:revision/revert(.:format)                        posts#revert {:revision=>/\d+/}
                          post_recover PUT      /posts/:post_id/recover(.:format)                                           posts#recover
                    destroy_many_posts DELETE   /posts/destroy_many(.:format)                                               posts#destroy_many
                                       GET      /posts(.:format)                                                            posts#index
                                       POST     /posts(.:format)                                                            posts#create
                              new_post GET      /posts/new(.:format)                                                        posts#new
                             edit_post GET      /posts/:id/edit(.:format)                                                   posts#edit
                                  post GET      /posts/:id(.:format)                                                        posts#show
                                       PATCH    /posts/:id(.:format)                                                        posts#update
                                       PUT      /posts/:id(.:format)                                                        posts#update
                                       DELETE   /posts/:id(.:format)                                                        posts#destroy
                         notifications GET      /notifications(.:format)                                                    notifications#index
               notifications_mark_read PUT      /notifications/mark-read(.:format)                                          notifications#mark_read
                                       GET|POST /auth/:provider/callback(.:format)                                          users/omniauth_callbacks#complete
                          auth_failure GET|POST /auth/failure(.:format)                                                     users/omniauth_callbacks#failure
                          track_clicks GET      /clicks/track(.:format)                                                     clicks#track
                                clicks GET      /clicks(.:format)                                                           clicks#index
                                       POST     /clicks(.:format)                                                           clicks#create
                             new_click GET      /clicks/new(.:format)                                                       clicks#new
                            edit_click GET      /clicks/:id/edit(.:format)                                                  clicks#edit
                                 click GET      /clicks/:id(.:format)                                                       clicks#show
                                       PATCH    /clicks/:id(.:format)                                                       clicks#update
                                       PUT      /clicks/:id(.:format)                                                       clicks#update
                                       DELETE   /clicks/:id(.:format)                                                       clicks#destroy
                               excerpt GET      /excerpt(.:format)                                                          excerpt#show
                     post_action_users GET      /post_action_users(.:format)                                                post_action_users#index
                                       POST     /post_action_users(.:format)                                                post_action_users#create
                  new_post_action_user GET      /post_action_users/new(.:format)                                            post_action_users#new
                 edit_post_action_user GET      /post_action_users/:id/edit(.:format)                                       post_action_users#edit
                      post_action_user GET      /post_action_users/:id(.:format)                                            post_action_users#show
                                       PATCH    /post_action_users/:id(.:format)                                            post_action_users#update
                                       PUT      /post_action_users/:id(.:format)                                            post_action_users#update
                                       DELETE   /post_action_users/:id(.:format)                                            post_action_users#destroy
                    users_post_actions GET      /post_actions/users(.:format)                                               post_actions#users
              defer_flags_post_actions POST     /post_actions/defer_flags(.:format)                                         post_actions#defer_flags
                          post_actions GET      /post_actions(.:format)                                                     post_actions#index
                                       POST     /post_actions(.:format)                                                     post_actions#create
                       new_post_action GET      /post_actions/new(.:format)                                                 post_actions#new
                      edit_post_action GET      /post_actions/:id/edit(.:format)                                            post_actions#edit
                           post_action GET      /post_actions/:id(.:format)                                                 post_actions#show
                                       PATCH    /post_actions/:id(.:format)                                                 post_actions#update
                                       PUT      /post_actions/:id(.:format)                                                 post_actions#update
                                       DELETE   /post_actions/:id(.:format)                                                 post_actions#destroy
                          user_actions GET      /user_actions(.:format)                                                     user_actions#index
                                       POST     /user_actions(.:format)                                                     user_actions#create
                       new_user_action GET      /user_actions/new(.:format)                                                 user_actions#new
                      edit_user_action GET      /user_actions/:id/edit(.:format)                                            user_actions#edit
                           user_action GET      /user_actions/:id(.:format)                                                 user_actions#show
                                       PATCH    /user_actions/:id(.:format)                                                 user_actions#update
                                       PUT      /user_actions/:id(.:format)                                                 user_actions#update
                                       DELETE   /user_actions/:id(.:format)                                                 user_actions#destroy
                                badges GET      /badges(.:format)                                                           badges#index
                                       GET      /badges/:id(/:slug)(.:format)                                               badges#show
                           user_badges GET      /user_badges(.:format)                                                      user_badges#index
                                       POST     /user_badges(.:format)                                                      user_badges#create
                            user_badge DELETE   /user_badges/:id(.:format)                                                  user_badges#destroy
                                     c GET      /c(.:format)                                                                redirect(301, /categories)
                            categories GET      /categories(.:format)                                                       categories#index
                                       POST     /categories(.:format)                                                       categories#create
                          new_category GET      /categories/new(.:format)                                                   categories#new
                         edit_category GET      /categories/:id/edit(.:format)                                              categories#edit
                              category PATCH    /categories/:id(.:format)                                                   categories#update
                                       PUT      /categories/:id(.:format)                                                   categories#update
                                       DELETE   /categories/:id(.:format)                                                   categories#destroy
                                       POST     /category/:category_id/move(.:format)                                       categories#move
                    categories_reorder POST     /categories/reorder(.:format)                                               categories#reorder
                                       POST     /category/:category_id/notifications(.:format)                              categories#set_notifications
                                       PUT      /category/:category_id/slug(.:format)                                       categories#update_slug
                                       GET      /c/:id/show(.:format)                                                       categories#show
                                       GET      /c/:category_slug/find_by_slug(.:format)                                    categories#find_by_slug
                                       GET      /c/:parent_category_slug/:category_slug/find_by_slug(.:format)              categories#find_by_slug
                                       GET      /c/:category.rss(.:format)                                                  list#category_feed
                                       GET      /c/:parent_category/:category.rss(.:format)                                 list#category_feed
                                       GET      /c/:category(.:format)                                                      list#category_latest
                                       GET      /c/:category/none(.:format)                                                 list#category_none_latest
                                       GET      /c/:parent_category/:category(/:id)(.:format)                               list#parent_category_category_latest {:id=>/\d+/}
                          category_top GET      /c/:category/l/top(.:format)                                                list#category_top
                     category_none_top GET      /c/:category/none/l/top(.:format)                                           list#category_none_top
          parent_category_category_top GET      /c/:parent_category/:category/l/top(.:format)                               list#parent_category_category_top
               category_hashtags_check GET      /category_hashtags/check(.:format)                                          category_hashtags#check
                               top_all GET      /top/all(.:format)                                                          list#top_all
                      category_top_all GET      /c/:category/l/top/all(.:format)                                            list#category_top_all
                 category_none_top_all GET      /c/:category/none/l/top/all(.:format)                                       list#category_none_top_all
      parent_category_category_top_all GET      /c/:parent_category/:category/l/top/all(.:format)                           list#parent_category_category_top_all
                            top_yearly GET      /top/yearly(.:format)                                                       list#top_yearly
                   category_top_yearly GET      /c/:category/l/top/yearly(.:format)                                         list#category_top_yearly
              category_none_top_yearly GET      /c/:category/none/l/top/yearly(.:format)                                    list#category_none_top_yearly
   parent_category_category_top_yearly GET      /c/:parent_category/:category/l/top/yearly(.:format)                        list#parent_category_category_top_yearly
                         top_quarterly GET      /top/quarterly(.:format)                                                    list#top_quarterly
                category_top_quarterly GET      /c/:category/l/top/quarterly(.:format)                                      list#category_top_quarterly
           category_none_top_quarterly GET      /c/:category/none/l/top/quarterly(.:format)                                 list#category_none_top_quarterly
parent_category_category_top_quarterly GET      /c/:parent_category/:category/l/top/quarterly(.:format)                     list#parent_category_category_top_quarterly
                           top_monthly GET      /top/monthly(.:format)                                                      list#top_monthly
                  category_top_monthly GET      /c/:category/l/top/monthly(.:format)                                        list#category_top_monthly
             category_none_top_monthly GET      /c/:category/none/l/top/monthly(.:format)                                   list#category_none_top_monthly
  parent_category_category_top_monthly GET      /c/:parent_category/:category/l/top/monthly(.:format)                       list#parent_category_category_top_monthly
                            top_weekly GET      /top/weekly(.:format)                                                       list#top_weekly
                   category_top_weekly GET      /c/:category/l/top/weekly(.:format)                                         list#category_top_weekly
              category_none_top_weekly GET      /c/:category/none/l/top/weekly(.:format)                                    list#category_none_top_weekly
   parent_category_category_top_weekly GET      /c/:parent_category/:category/l/top/weekly(.:format)                        list#parent_category_category_top_weekly
                             top_daily GET      /top/daily(.:format)                                                        list#top_daily
                    category_top_daily GET      /c/:category/l/top/daily(.:format)                                          list#category_top_daily
               category_none_top_daily GET      /c/:category/none/l/top/daily(.:format)                                     list#category_none_top_daily
    parent_category_category_top_daily GET      /c/:parent_category/:category/l/top/daily(.:format)                         list#parent_category_category_top_daily
                                       GET      /latest.rss(.:format)                                                       list#latest_feed
                                       GET      /top.rss(.:format)                                                          list#top_feed
                                       GET      /categories.rss(.:format)                                                   list#categories_feed
                                latest GET      /latest(.:format)                                                           list#latest {:format=>/(json|html)/}
                       category_latest GET      /c/:category/l/latest(.:format)                                             list#category_latest
                  category_none_latest GET      /c/:category/none/l/latest(.:format)                                        list#category_none_latest
       parent_category_category_latest GET      /c/:parent_category/:category/l/latest(.:format)                            list#parent_category_category_latest
                                unread GET      /unread(.:format)                                                           list#unread {:format=>/(json|html)/}
                       category_unread GET      /c/:category/l/unread(.:format)                                             list#category_unread
                  category_none_unread GET      /c/:category/none/l/unread(.:format)                                        list#category_none_unread
       parent_category_category_unread GET      /c/:parent_category/:category/l/unread(.:format)                            list#parent_category_category_unread
                                   new GET      /new(.:format)                                                              list#new {:format=>/(json|html)/}
                          category_new GET      /c/:category/l/new(.:format)                                                list#category_new
                     category_none_new GET      /c/:category/none/l/new(.:format)                                           list#category_none_new
          parent_category_category_new GET      /c/:parent_category/:category/l/new(.:format)                               list#parent_category_category_new
                                  read GET      /read(.:format)                                                             list#read {:format=>/(json|html)/}
                         category_read GET      /c/:category/l/read(.:format)                                               list#category_read
                    category_none_read GET      /c/:category/none/l/read(.:format)                                          list#category_none_read
         parent_category_category_read GET      /c/:parent_category/:category/l/read(.:format)                              list#parent_category_category_read
                                posted GET      /posted(.:format)                                                           list#posted {:format=>/(json|html)/}
                       category_posted GET      /c/:category/l/posted(.:format)                                             list#category_posted
                  category_none_posted GET      /c/:category/none/l/posted(.:format)                                        list#category_none_posted
       parent_category_category_posted GET      /c/:parent_category/:category/l/posted(.:format)                            list#parent_category_category_posted
                             bookmarks GET      /bookmarks(.:format)                                                        list#bookmarks {:format=>/(json|html)/}
                    category_bookmarks GET      /c/:category/l/bookmarks(.:format)                                          list#category_bookmarks
               category_none_bookmarks GET      /c/:category/none/l/bookmarks(.:format)                                     list#category_none_bookmarks
    parent_category_category_bookmarks GET      /c/:parent_category/:category/l/bookmarks(.:format)                         list#parent_category_category_bookmarks
                                       GET      /category/*path(.:format)                                                   categories#redirect
                                   top GET      /top(.:format)                                                              list#top
                          search_query GET      /search/query(.:format)                                                     search#query
                                search GET      /search(.:format)                                                           search#show
                                       GET      /t/:id(.:format)                                                            topics#show
                                     t POST     /t(.:format)                                                                topics#create
                                       PUT      /t/:id(.:format)                                                            topics#update
                                       DELETE   /t/:id(.:format)                                                            topics#destroy
                                       PUT      /t/:id/archive-message(.:format)                                            topics#archive_message
                                       PUT      /t/:id/move-to-inbox(.:format)                                              topics#move_to_inbox
                                       PUT      /t/:id/convert-topic/:type(.:format)                                        topics#convert_topic
                           topics_bulk PUT      /topics/bulk(.:format)                                                      topics#bulk
                      topics_reset_new PUT      /topics/reset-new(.:format)                                                 topics#reset_new
                        topics_timings POST     /topics/timings(.:format)                                                   topics#timings
                     topics_similar_to GET      /topics/similar_to(.:format)                                                similar_topics#index
                        similar_topics GET      /similar_topics(.:format)                                                   similar_topics#index
                                       POST     /similar_topics(.:format)                                                   similar_topics#create
                     new_similar_topic GET      /similar_topics/new(.:format)                                               similar_topics#new
                    edit_similar_topic GET      /similar_topics/:id/edit(.:format)                                          similar_topics#edit
                         similar_topic GET      /similar_topics/:id(.:format)                                               similar_topics#show
                                       PATCH    /similar_topics/:id(.:format)                                               similar_topics#update
                                       PUT      /similar_topics/:id(.:format)                                               similar_topics#update
                                       DELETE   /similar_topics/:id(.:format)                                               similar_topics#destroy
                  topics_feature_stats GET      /topics/feature_stats(.:format)                                             topics#feature_stats
                             topics_by GET      /topics/created-by/:username(.:format)                                      list#topics_by {:username=>/[\w.\-]+/}
               topics_private_messages GET      /topics/private-messages/:username(.:format)                                list#private_messages {:username=>/[\w.\-]+/}
          topics_private_messages_sent GET      /topics/private-messages-sent/:username(.:format)                           list#private_messages_sent {:username=>/[\w.\-]+/}
       topics_private_messages_archive GET      /topics/private-messages-archive/:username(.:format)                        list#private_messages_archive {:username=>/[\w.\-]+/}
        topics_private_messages_unread GET      /topics/private-messages-unread/:username(.:format)                         list#private_messages_unread {:username=>/[\w.\-]+/}
         topics_private_messages_group GET      /topics/private-messages-group/:username/:group_name.json(.:format)         list#private_messages_group {:username=>/[\w.\-]+/, :group_name=>/[\w.\-]+/}
 topics_private_messages_group_archive GET      /topics/private-messages-group/:username/:group_name/archive.json(.:format) list#private_messages_group_archive {:username=>/[\w.\-]+/, :group_name=>/[\w.\-]+/}
                        embed_comments GET      /embed/comments(.:format)                                                   embed#comments
                           embed_count GET      /embed/count(.:format)                                                      embed#count
                            embed_info GET      /embed/info(.:format)                                                       embed#info
                             new_topic GET      /new-topic(.:format)                                                        list#latest
                           new_message GET      /new-message(.:format)                                                      list#latest
                                       GET      /t/id_for/:slug(.:format)                                                   topics#id_for_slug
                                       GET      /t/:slug/:topic_id/wordpress(.:format)                                      topics#wordpress {:topic_id=>/\d+/}
                                       GET      /t/:topic_id/wordpress(.:format)                                            topics#wordpress {:topic_id=>/\d+/}
                                       GET      /t/:slug/:topic_id/moderator-liked(.:format)                                topics#moderator_liked {:topic_id=>/\d+/}
                                       GET      /t/:slug/:topic_id/summary(.:format)                                        topics#show {:summary=>true, :topic_id=>/\d+/}
                                       GET      /t/:slug/:topic_id/unsubscribe(.:format)                                    topics#unsubscribe {:topic_id=>/\d+/}
                                       GET      /t/:topic_id/unsubscribe(.:format)                                          topics#unsubscribe {:topic_id=>/\d+/}
                                       GET      /t/:topic_id/summary(.:format)                                              topics#show {:topic_id=>/\d+/}
                                       PUT      /t/:slug/:topic_id(.:format)                                                topics#update {:topic_id=>/\d+/}
                                       PUT      /t/:slug/:topic_id/star(.:format)                                           topics#star {:topic_id=>/\d+/}
                                       PUT      /t/:topic_id/star(.:format)                                                 topics#star {:topic_id=>/\d+/}
                                       PUT      /t/:slug/:topic_id/status(.:format)                                         topics#status {:topic_id=>/\d+/}
                                       PUT      /t/:topic_id/status(.:format)                                               topics#status {:topic_id=>/\d+/}
                                       PUT      /t/:topic_id/clear-pin(.:format)                                            topics#clear_pin {:topic_id=>/\d+/}
                                       PUT      /t/:topic_id/re-pin(.:format)                                               topics#re_pin {:topic_id=>/\d+/}
                                       PUT      /t/:topic_id/mute(.:format)                                                 topics#mute {:topic_id=>/\d+/}
                                       PUT      /t/:topic_id/unmute(.:format)                                               topics#unmute {:topic_id=>/\d+/}
                                       PUT      /t/:topic_id/autoclose(.:format)                                            topics#autoclose {:topic_id=>/\d+/}
                                       PUT      /t/:topic_id/make-banner(.:format)                                          topics#make_banner {:topic_id=>/\d+/}
                                       PUT      /t/:topic_id/remove-banner(.:format)                                        topics#remove_banner {:topic_id=>/\d+/}
                                       PUT      /t/:topic_id/remove-allowed-user(.:format)                                  topics#remove_allowed_user {:topic_id=>/\d+/}
                                       PUT      /t/:topic_id/remove-allowed-group(.:format)                                 topics#remove_allowed_group {:topic_id=>/\d+/}
                                       PUT      /t/:topic_id/recover(.:format)                                              topics#recover {:topic_id=>/\d+/}
                                       GET      /t/:topic_id/:post_number(.:format)                                         topics#show {:topic_id=>/\d+/, :post_number=>/\d+/}
                                       GET      /t/:topic_id/last(.:format)                                                 topics#show {:post_number=>99999999, :topic_id=>/\d+/}
                                       GET      /t/:slug/:topic_id.rss(.:format)                                            topics#feed {:topic_id=>/\d+/}
                                       GET      /t/:slug/:topic_id(.:format)                                                topics#show {:topic_id=>/\d+/}
                                       GET      /t/:slug/:topic_id/:post_number(.:format)                                   topics#show {:topic_id=>/\d+/, :post_number=>/\d+/}
                                       GET      /t/:slug/:topic_id/last(.:format)                                           topics#show {:post_number=>99999999, :topic_id=>/\d+/}
                                       GET      /t/:topic_id/posts(.:format)                                                topics#posts {:topic_id=>/\d+/}
                                       POST     /t/:topic_id/timings(.:format)                                              topics#timings {:topic_id=>/\d+/}
                                       POST     /t/:topic_id/invite(.:format)                                               topics#invite {:topic_id=>/\d+/}
                                       POST     /t/:topic_id/invite-group(.:format)                                         topics#invite_group {:topic_id=>/\d+/}
                                       POST     /t/:topic_id/move-posts(.:format)                                           topics#move_posts {:topic_id=>/\d+/}
                                       POST     /t/:topic_id/merge-topic(.:format)                                          topics#merge_topic {:topic_id=>/\d+/}
                                       POST     /t/:topic_id/change-owner(.:format)                                         topics#change_post_owners {:topic_id=>/\d+/}
                                       PUT      /t/:topic_id/change-timestamp(.:format)                                     topics#change_timestamps {:topic_id=>/\d+/}
                                       DELETE   /t/:topic_id/timings(.:format)                                              topics#destroy_timings {:topic_id=>/\d+/}
                                       PUT      /t/:topic_id/bookmark(.:format)                                             topics#bookmark {:topic_id=>/\d+/}
                                       PUT      /t/:topic_id/remove_bookmarks(.:format)                                     topics#remove_bookmarks {:topic_id=>/\d+/}
                                       POST     /t/:topic_id/notifications(.:format)                                        topics#set_notifications {:topic_id=>/\d+/}
                                       GET      /p/:post_id(/:user_id)(.:format)                                            posts#short_link
                                       GET      /posts/:id/cooked(.:format)                                                 posts#cooked
                                       GET      /posts/:id/expand-embed(.:format)                                           posts#expand_embed
                                       GET      /posts/:id/raw(.:format)                                                    posts#markdown_id
                                       GET      /posts/:id/raw-email(.:format)                                              posts#raw_email
                                       GET      /raw/:topic_id(/:post_number)(.:format)                                     posts#markdown_num
                          queued_posts GET      /queued_posts(.:format)                                                     queued_posts#index
                                       POST     /queued_posts(.:format)                                                     queued_posts#create
                       new_queued_post GET      /queued_posts/new(.:format)                                                 queued_posts#new
                      edit_queued_post GET      /queued_posts/:id/edit(.:format)                                            queued_posts#edit
                           queued_post GET      /queued_posts/:id(.:format)                                                 queued_posts#show
                                       PATCH    /queued_posts/:id(.:format)                                                 queued_posts#update
                                       PUT      /queued_posts/:id(.:format)                                                 queued_posts#update
                                       DELETE   /queued_posts/:id(.:format)                                                 queued_posts#destroy
                                       GET      /queued-posts(.:format)                                                     queued_posts#index
                        upload_invites GET      /invites/upload(.:format)                                                   invites#check_csv_chunk
                                       POST     /invites/upload(.:format)                                                   invites#upload_csv_chunk
                               invites GET      /invites(.:format)                                                          invites#index
                                       POST     /invites(.:format)                                                          invites#create
                            new_invite GET      /invites/new(.:format)                                                      invites#new
                           edit_invite GET      /invites/:id/edit(.:format)                                                 invites#edit
                                invite GET      /invites/:id(.:format)                                                      invites#show
                                       PATCH    /invites/:id(.:format)                                                      invites#update
                                       PUT      /invites/:id(.:format)                                                      invites#update
                                       DELETE   /invites/:id(.:format)                                                      invites#destroy
                      invites_reinvite POST     /invites/reinvite(.:format)                                                 invites#resend_invite
                  invites_reinvite_all POST     /invites/reinvite-all(.:format)                                             invites#resend_all_invites
                          invites_link POST     /invites/link(.:format)                                                     invites#create_invite_link
                    invites_disposable POST     /invites/disposable(.:format)                                               invites#create_disposable_invite
                                       GET      /invites/redeem/:token(.:format)                                            invites#redeem_disposable_invite
                                       DELETE   /invites(.:format)                                                          invites#destroy
        export_entity_export_csv_index POST     /export_csv/export_entity(.:format)                                         export_csv#export_entity
                                       GET      /export_csv/:id(.:format)                                                   export_csv#show {:id=>/[^\/]+/}
                      export_csv_index GET      /export_csv(.:format)                                                       export_csv#index
                                       POST     /export_csv(.:format)                                                       export_csv#create
                        new_export_csv GET      /export_csv/new(.:format)                                                   export_csv#new
                       edit_export_csv GET      /export_csv/:id/edit(.:format)                                              export_csv#edit
                            export_csv GET      /export_csv/:id(.:format)                                                   export_csv#show
                                       PATCH    /export_csv/:id(.:format)                                                   export_csv#update
                                       PUT      /export_csv/:id(.:format)                                                   export_csv#update
                                       DELETE   /export_csv/:id(.:format)                                                   export_csv#destroy
                                onebox GET      /onebox(.:format)                                                           onebox#show
                             exception GET      /exception(.:format)                                                        list#latest
                      message_bus_poll GET      /message-bus/poll(.:format)                                                 message_bus#poll
                                 draft GET      /draft(.:format)                                                            draft#show
                                       POST     /draft(.:format)                                                            draft#update
                                       DELETE   /draft(.:format)                                                            draft#destroy
                                       GET      /cdn_asset/:site/*path                                                      static#cdn_asset
                       favicon_proxied GET      /favicon/proxied                                                            static#favicon
                                       GET      /robots.txt(.:format)                                                       robots_txt#index
                              manifest GET      /manifest.json(.:format)                                                    metadata#manifest
                            opensearch GET      /opensearch(.:format)                                                       metadata#opensearch
                                       GET      /tags(.:format)                                                             tags#index
                           filter_list GET      /tags/filter/list(.:format)                                                 tags#index
                         filter_search GET      /tags/filter/search(.:format)                                               tags#search
                                 check GET      /tags/check(.:format)                                                       tags#check_hashtag
                                       GET      /tags/:tag_id.rss(.:format)                                                 tags#tag_feed {:tag_id=>/[^\/]+?/, :format=>/json|rss/}
                           list_by_tag GET      /tags/:tag_id(.:format)                                                     tags#show {:tag_id=>/[^\/]+?/, :format=>/json|rss/}
                                       GET      /tags/c/:category/:tag_id(.:format)                                         tags#show {:tag_id=>/[^\/]+?/, :format=>/json|rss/}
                                       GET      /tags/c/:parent_category/:category/:tag_id(.:format)                        tags#show {:tag_id=>/[^\/]+?/, :format=>/json|rss/}
                                       GET      /tags/:tag_id/notifications(.:format)                                       tags#notifications {:tag_id=>/[^\/]+?/, :format=>/json|rss/}
                                       PUT      /tags/:tag_id/notifications(.:format)                                       tags#update_notifications {:tag_id=>/[^\/]+?/, :format=>/json|rss/}
                                       PUT      /tags/:tag_id(.:format)                                                     tags#update {:tag_id=>/[^\/]+?/, :format=>/json|rss/}
                                       DELETE   /tags/:tag_id(.:format)                                                     tags#destroy {:tag_id=>/[^\/]+?/, :format=>/json|rss/}
                                       GET      /tags/:tag_id/l/latest(.:format)                                            tags#show_latest {:tag_id=>/[^\/]+?/, :format=>/json|rss/}
                                       GET      /tags/c/:category/:tag_id/l/latest(.:format)                                tags#show_latest {:tag_id=>/[^\/]+?/, :format=>/json|rss/}
                                       GET      /tags/c/:parent_category/:category/:tag_id/l/latest(.:format)               tags#show_latest {:tag_id=>/[^\/]+?/, :format=>/json|rss/}
                                       GET      /tags/:tag_id/l/unread(.:format)                                            tags#show_unread {:tag_id=>/[^\/]+?/, :format=>/json|rss/}
                                       GET      /tags/c/:category/:tag_id/l/unread(.:format)                                tags#show_unread {:tag_id=>/[^\/]+?/, :format=>/json|rss/}
                                       GET      /tags/c/:parent_category/:category/:tag_id/l/unread(.:format)               tags#show_unread {:tag_id=>/[^\/]+?/, :format=>/json|rss/}
                                       GET      /tags/:tag_id/l/new(.:format)                                               tags#show_new {:tag_id=>/[^\/]+?/, :format=>/json|rss/}
                                       GET      /tags/c/:category/:tag_id/l/new(.:format)                                   tags#show_new {:tag_id=>/[^\/]+?/, :format=>/json|rss/}
                                       GET      /tags/c/:parent_category/:category/:tag_id/l/new(.:format)                  tags#show_new {:tag_id=>/[^\/]+?/, :format=>/json|rss/}
                                       GET      /tags/:tag_id/l/read(.:format)                                              tags#show_read {:tag_id=>/[^\/]+?/, :format=>/json|rss/}
                                       GET      /tags/c/:category/:tag_id/l/read(.:format)                                  tags#show_read {:tag_id=>/[^\/]+?/, :format=>/json|rss/}
                                       GET      /tags/c/:parent_category/:category/:tag_id/l/read(.:format)                 tags#show_read {:tag_id=>/[^\/]+?/, :format=>/json|rss/}
                                       GET      /tags/:tag_id/l/posted(.:format)                                            tags#show_posted {:tag_id=>/[^\/]+?/, :format=>/json|rss/}
                                       GET      /tags/c/:category/:tag_id/l/posted(.:format)                                tags#show_posted {:tag_id=>/[^\/]+?/, :format=>/json|rss/}
                                       GET      /tags/c/:parent_category/:category/:tag_id/l/posted(.:format)               tags#show_posted {:tag_id=>/[^\/]+?/, :format=>/json|rss/}
                                       GET      /tags/:tag_id/l/bookmarks(.:format)                                         tags#show_bookmarks {:tag_id=>/[^\/]+?/, :format=>/json|rss/}
                                       GET      /tags/c/:category/:tag_id/l/bookmarks(.:format)                             tags#show_bookmarks {:tag_id=>/[^\/]+?/, :format=>/json|rss/}
                                       GET      /tags/c/:parent_category/:category/:tag_id/l/bookmarks(.:format)            tags#show_bookmarks {:tag_id=>/[^\/]+?/, :format=>/json|rss/}
              filter_search_tag_groups GET      /tag_groups/filter/search(.:format)                                         tag_groups#search
                            tag_groups GET      /tag_groups(.:format)                                                       tag_groups#index
                                       POST     /tag_groups(.:format)                                                       tag_groups#create
                             tag_group GET      /tag_groups/:id(.:format)                                                   tag_groups#show
                                       PATCH    /tag_groups/:id(.:format)                                                   tag_groups#update
                                       PUT      /tag_groups/:id(.:format)                                                   tag_groups#update
                                       DELETE   /tag_groups/:id(.:format)                                                   tag_groups#destroy
                           list_latest GET      /                                                                           list#latest
                           list_unread GET      /                                                                           list#unread
                              list_new GET      /                                                                           list#new
                             list_read GET      /                                                                           list#read
                           list_posted GET      /                                                                           list#posted
                        list_bookmarks GET      /                                                                           list#bookmarks
                      categories_index GET      /                                                                           categories#index
                             top_lists GET      /                                                                           list#top
                                       GET      /*url(.:format)                                                             permalinks#show
