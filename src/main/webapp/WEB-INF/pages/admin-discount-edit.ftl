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
                    <li><a href="/adminOrganizations"><span>Организации</span></a></li>
                    <li><a href="/adminDiscounts" class="active"><span>Акции</span></a></li>
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
                        <div class="box">
                            <!-- Box Head -->
                            <div class="box-head">
                                <h2>Add New Discount</h2>
                            </div>
                            <!-- End Box Head -->

                            <form action="${uri}" method="post">

                                <!-- Form -->
                                <div class="form">
                                    <p>
                                        <label>Organization ID</label>
                                        <input name="organization_id" type="text" class="field size3"
                                                <#if discount??> value="${discount.organization.id}" </#if>/>
                                        <label>Title</label>
                                        <input name="title" type="text" class="field size1"
                                                <#if discount??> value="${discount.title}" </#if>/>
                                        <label>Date</label>
                                        <input name="date" type="text" class="field size1"
                                                <#if discount??> value="${discount.date?date?string["dd.MM.yyyy"]}" </#if>/>
                                    </p>
                                    <p>
                                        <span class="req">max 500 symbols</span>
                                        <label>Info</label>
                                        <textarea name="info" class="field size1" rows="10" cols="30"><#if discount??>${discount.info}</#if></textarea>
                                    </p>
                                    <#if discount??>
                                        <input name="edit" value="${discount.id}" style="display: none">
                                    </#if>

                                </div>
                                <!-- End Form -->
                                <!-- Form Buttons -->
                                <div class="buttons">
                                    <input type="submit" class="button" value="submit" />
                                </div>
                                <!-- End Form Buttons -->
                            </form>
                            <#if discount??>
                                <form action="/discount-image-upload" enctype="multipart/form-data" method="post">
                                    <input name="id" style="display: none" value="${discount.id}">
                                    <label>Картинка</label>
                                    <input type="file" name="image" accept=".jpg, .jpeg, .png"
                                           onchange="this.form.submit();" style="padding: 30px">
                                </form>
                            </#if>
                        </div>
                    </div>

                </div>
            </div>
            <!-- Main -->
        </div>
    </div>
</@base.common>