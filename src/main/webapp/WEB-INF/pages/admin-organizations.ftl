<#import "bases/common.ftl" as base>

<@base.common "AdminPanel" "/static/css/admin2.css" "">
    <div id="header">
        <div class="shell">
            <!-- Logo + Top Nav -->
            <div id="top">
                <h1><a href="#">AdminPanel</a></h1>
                <div id="top-navigation">
                    Welcome <a href="#"><strong>${user.name}</strong></a>
                    <span>|</span>
                    <a href="/logout">Log out</a>
                </div>
            </div>
            <!-- End Logo + Top Nav -->

            <!-- Main Nav -->
            <div id="navigation">
                <ul>
                    <li><a href="/adminOrganizations" class="active"><span>Организации</span></a></li>
                    <li><a href="/adminDiscounts"><span>Акции</span></a></li>
                </ul>
            </div>
            <!-- End Main Nav -->

        </div>
    </div>
    <!-- End Header -->

    <!-- Container -->
    <div id="container">
        <div class="shell">

            <br />
            <!-- Main -->
            <div id="main">
                <div class="cl">&nbsp;</div>

                <!-- Content -->
                <div id="content">

                    <!-- Box -->
                    <div class="box">
                        <!-- Box Head -->
                        <div class="box-head">
                            <h2 class="left">Organizations</h2>
                        </div>
                        <!-- End Box Head -->

                        <!-- Table -->
                        <div class="table">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Type</th>
                                    <th width="110" class="ac">Content Control</th>
                                </tr>

                                <#list organizations as org>
                                <tr>
                                    <td><h3>${org.id}</h3></td>
                                    <td><h3><a href="/adminOrganizationEdit?edit=${org.id}">${org.name}</a></h3></td>
                                    <td><h3>${org.type}</h3></td>
                                    <td>
                                        <a href="/adminOrganizationEdit?delete=${org.id}" class="ico del">Delete</a>
                                        <a href="/adminOrganizationEdit?edit=${org.id}" class="ico edit">Edit</a>
                                    </td>
                                </tr>
                                </#list>
                            </table>
                        </div>
                        <!-- Table -->

                    </div>

                </div>

                <!-- Sidebar -->
                <div id="sidebar">

                    <!-- Box -->
                    <div class="box">

                        <!-- Box Head -->
                        <div class="box-head">
                            <h2>Management</h2>
                        </div>
                        <!-- End Box Head-->

                        <div class="box-content">
                            <a href="/newOrganization" class="add-button"><span>New Organization</span></a>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>
                    <!-- End Box -->
                </div>
                <!-- End Sidebar -->

                <div class="cl">&nbsp;</div>
            </div>
            <!-- Main -->
        </div>
    </div>
</@base.common>